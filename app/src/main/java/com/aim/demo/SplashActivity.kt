package com.aim.demo

import android.animation.Animator
import android.annotation.SuppressLint
import android.app.Activity
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.aim.demo.databinding.ActivitySplashBinding
import com.dr.mgr.session.Constants
import com.dr.mgr.session.SharedHelper
import com.dr.mgr.utils.BaseUtils
import com.dr.mgr.utils.BaseUtils.decrypt
import com.dr.mgr.utils.BaseUtils.encrypt
import com.dr.mgr.utils.UiUtils
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import java.util.*
import java.util.concurrent.Executor
import kotlin.math.roundToInt


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    lateinit var sharedHelper:SharedHelper
    var page = 0
    var key = -1
    private val RC_SIGN_IN = 9001
    private val SMS_CONSENT_REQUEST = 9002
    lateinit var callbackManager: CallbackManager
    var count = 0
    var someActivityResultLauncher = registerForActivityResult<Intent, ActivityResult>(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            // There are no request codes
            val data = result.data
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedHelper = SharedHelper(this)

        if (intent.extras != null && sharedHelper.loggedIn) {
            for (key in intent.extras!!.keySet()) {
                val value = intent.extras!!.get(key)
                Log.d("cvbnm", "Key: $key Value: $value")
                val bundle = Bundle()
                if(key == "module"){
                    bundle.putString("page",value.toString())
                }
                else if(key == "id"){
                    bundle.putString("id",value.toString())
                    BaseUtils.startActivity(this,DashBoardActivity(),bundle,true)
                }
            }
        }

       // binding.animViewMain.setAnimation("splash_new.json")
       // binding.animViewMain.playAnimation()
        key = intent.getIntExtra(Constants.IntentKeys.KEY,-1)
        //checkLogin()

        if(key == 0){
            loadPage1()
            val apiUrl = intent.getStringExtra(Constants.IntentKeys.KEY1).toString()
            if(apiUrl.isNotEmpty()){
                UiUtils.showSnack(apiUrl,binding.root)
            }
        }
        else if(key == 1){
            loadPage3()
        }
        else {
            binding.animViewMain.addAnimatorListener(object : Animator.AnimatorListener{
                override fun onAnimationStart(p0: Animator) {
                }

                override fun onAnimationEnd(p0: Animator) {

                }

                override fun onAnimationCancel(p0: Animator) {
                }

                override fun onAnimationRepeat(p0: Animator) {
                    if(count == 1){
                        count = 2
                        checkLogin()
                    }
                    else if(count == 0){
                        count = 1
                    }
                }
            })
        }

        binding.edtPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
               /* binding.edtPhone.text.trim()
                val str = binding.edtPhone.text.toString()
                if(str.length == 1 && (str != "6" && str != "7" && str != "8" && str != "9")){
                    binding.edtPhone.text.clear()
                }*/
            }
        })

        
        binding.donothave.setOnClickListener {
            loadPage1()
        }

        binding.already.setOnClickListener {
            loadPage3()
        }

        binding.getStarted2.setOnClickListener {
            if(binding.edtMail.text.isEmpty()){
                UiUtils.showSnack("Please Enter Mail Id",binding.root)
            }
            else if(binding.edtPassword.text.isEmpty()){
                UiUtils.showSnack("Please Enter Password",binding.root)
            }
            else if(binding.edtPassword.text.length < 3){
                UiUtils.showSnack("Please Enter Valid Password",binding.root)
            }
            else{
                sharedHelper.loggedIn = true
                moveNext()
            }
        }

        binding.getStarted1.setOnClickListener {
            if(binding.edtPhone.text.toString().isEmpty()){
                UiUtils.showSnack("Please Enter Mobile Number",binding.root)
            }
            /*else if(binding.edtPhone.text.length != 10){
                UiUtils.showSnack("Please Enter Valid Mobile Number",binding.root)
            }*/
            else{
                sendOtp()
            }
        }

        binding.resendOtp.setOnClickListener {
            sendOtp()
        }

        binding.changePhone.setOnClickListener {
            onBackPressed()
        }

        binding.next.setOnClickListener {
            if(binding.otp1.text.toString().isNotEmpty() && binding.otp2.text.toString().isNotEmpty() && binding.otp3.text.toString().isNotEmpty() && binding.otp4.text.toString().isNotEmpty() && binding.otp5.text.toString().isNotEmpty() && binding.otp6.text.toString().isNotEmpty()){
                val otp = binding.otp1.text.toString()+binding.otp2.text.toString()+binding.otp3.text.toString()+binding.otp4.text.toString()+binding.otp5.text.toString()+binding.otp6.text.toString()
                verifyOtp(otp)
            }
            else{
                UiUtils.showSnack("Please Enter Otp",binding.root)
            }
        }
        binding.next1.setOnClickListener {
            loadSubPage3()
        }

        binding.back.setOnClickListener {
            onBackPressed()
        }

        binding.next2.setOnClickListener {
            moveNext()
        }

        binding.eye.setOnClickListener {
            binding.eye.isSelected = !binding.eye.isSelected
            if(binding.eye.isSelected){
                binding.edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.edtPassword.setSelection(binding.edtPassword.text!!.length)
            }
            else{
                binding.edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.edtPassword.setSelection(binding.edtPassword.text!!.length)
            }
        }


      //  startSmsUserConsent()
       // bioMetric()
        loadOtp()
        loadCode1()
        loadCode2()
       // whatsappLogin()
        // facebookLogin()
       // googleLogin()
       // hari()
    }

    fun animation(context: Context, view: View, type: Int, visible: Boolean){
        val anim: Animation = AnimationUtils.loadAnimation(context,type)
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                if(visible){
                    view.alpha = 1F
                    view.visibility = View.VISIBLE
                    checkLogin()
                }
                else{
                    // view.alpha = 1F
                    view.visibility = View.GONE
                }
            }
            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
        view.startAnimation(anim)
    }

    private fun timer(){
        binding.resendOtp.visibility = View.VISIBLE
        binding.resendOtp.isEnabled = false
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val text = "${getString(R.string.resend_in)} ${":"} ${millisUntilFinished / 1000}${"s"}"
                binding.resendOtp.text = text
            }

            override fun onFinish() {
                binding.resendOtp.text = "Resend OTP"
                binding.resendOtp.isEnabled = true
            }
        }
        timer.start()
    }
    private fun sendOtp(){
        loadPage2(binding.edtPhone.text.toString())
    }

    private fun verifyOtp(otp:String){
       // sharedHelper.loggedIn = true
        loadSubPage2()
    }
    
    private fun loadOtp(){
        binding.otp1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }
            override fun afterTextChanged(editable: Editable) {
                if (editable.toString() != "") {
                    if(editable.toString().length == 1){
                        binding.otp2.isFocusable = true
                        binding.otp2.requestFocus()
                        //  UiUtils.editTextBgDrawable(binding.otp1,R.drawable.otp_back)
                    }
                    else if(editable.toString().length == 6){
                        binding.otp1.filters = arrayOf(InputFilter.LengthFilter(1))
                        getOtpFromMsg(editable.toString()+"\"Dr.M.G.R\"")
                    }
                }
                else{

                }
            }
        })
        binding.otp2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.toString() != "") {
                    binding.otp3.isFocusable = true
                    binding.otp3.requestFocus()
                   // UiUtils.editTextBgDrawable(binding.otp2,R.drawable.otp_back)
                } else {
                    binding.otp1.isFocusable = true
                    binding.otp1.requestFocus()
                }
            }
        })
        binding.otp3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.toString() != "") {
                    binding.otp4.isFocusable = true
                    binding.otp4.requestFocus()
                   // UiUtils.editTextBgDrawable(binding.otp3,R.drawable.otp_back)
                } else {
                    binding.otp2.isFocusable = true
                    binding.otp2.requestFocus()
                }
            }
        })
        binding.otp4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.toString() != "") {
                    binding.otp5.isFocusable = true
                    binding.otp5.requestFocus()
                  //  UiUtils.editTextBgDrawable(binding.otp4,R.drawable.otp_back)
                } else {
                    binding.otp3.isFocusable = true
                    binding.otp3.requestFocus()
                }
            }
        })
        binding.otp5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.toString() != "") {
                    binding.otp6.isFocusable = true
                    binding.otp6.requestFocus()
                    //  UiUtils.editTextBgDrawable(binding.otp4,R.drawable.otp_back)
                } else {
                    binding.otp4.isFocusable = true
                    binding.otp4.requestFocus()
                }
            }
        })
        binding.otp6.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.toString() != "") {
                    binding.otp6.isFocusable = true
                    binding.otp6.requestFocus()
                    //  UiUtils.editTextBgDrawable(binding.otp4,R.drawable.otp_back)
                } else {
                    binding.otp5.isFocusable = true
                    binding.otp5.requestFocus()
                }
            }
        })

        binding.otp2.setOnKeyListener(View.OnKeyListener { view, i, _ ->
            if (i == KeyEvent.KEYCODE_DEL) {
                if (binding.otp2.text.toString().isEmpty()) {
                    binding.otp1.setText("")
                    binding.otp1.requestFocus()
                }
            }
            false
        })
        binding.otp3.setOnKeyListener(View.OnKeyListener { view, i, _ ->
            if (i == KeyEvent.KEYCODE_DEL) {
                if (binding.otp3.text.toString().isEmpty()) {
                    binding.otp2.setText("")
                    binding.otp2.requestFocus()
                }
            }
            false
        })
        binding.otp4.setOnKeyListener(View.OnKeyListener { view, i, _ ->
            if (i == KeyEvent.KEYCODE_DEL) {
                if (binding.otp4.text.toString().isEmpty()) {
                    binding.otp3.setText("")
                    binding.otp3.requestFocus()
                }
            }
            false
        })
        binding.otp5.setOnKeyListener(View.OnKeyListener { view, i, _ ->
            if (i == KeyEvent.KEYCODE_DEL) {
                if (binding.otp5.text.toString().isEmpty()) {
                    binding.otp4.setText("")
                    binding.otp4.requestFocus()
                }
            }
            false
        })
        binding.otp6.setOnKeyListener(View.OnKeyListener { view, i, _ ->
            if (i == KeyEvent.KEYCODE_DEL) {
                if (binding.otp6.text.toString().isEmpty()) {
                    binding.otp5.setText("")
                    binding.otp5.requestFocus()
                }
            }
            false
        })
    }

    private fun loadCode1(){

    }

    private fun loadCode2(){

    }

    override fun onBackPressed() {
        when (page) {
            0,6 -> {
                super.onBackPressed()
            }
            1,2 -> {
                loadPage1()
            }
            3 -> {
                loadSubPage1()
            }
            4 -> {
                loadSubPage2()
            }
            5 -> {
                if(sharedHelper.loggedIn){
                    super.onBackPressed()
                }
                else{
                    loadPage1()
                }
            }
        }
    }

    private fun loadPage1(){
        page = 0
        binding.animViewMain.visibility = View.VISIBLE
        binding.top.visibility = View.VISIBLE
        binding.animViewTop.visibility = View.INVISIBLE
        binding.animViewSide.visibility = View.GONE
        binding.back.visibility = View.GONE
        binding.title.visibility = View.GONE
       // binding.botCard.visibility = View.VISIBLE
        binding.page1.visibility = View.VISIBLE
        binding.page2.visibility = View.GONE
        binding.page3.visibility = View.GONE

        binding.animViewMain.layoutParams.width = UiUtils.convertDpToPixel(286F,this).roundToInt()
        binding.animViewMain.layoutParams.height = UiUtils.convertDpToPixel(286F,this).roundToInt()
        val mainConstraint = binding.mainConstraint
        val constraintSet = ConstraintSet()
        constraintSet.clone(mainConstraint)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.TOP)
        constraintSet.connect(R.id.anim_view_main,ConstraintSet.TOP,R.id.anim_view_main,ConstraintSet.TOP)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.START)
        constraintSet.connect(R.id.anim_view_main,ConstraintSet.START,R.id.main_constraint,ConstraintSet.START)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.END)
        constraintSet.connect(R.id.anim_view_main,ConstraintSet.END,R.id.main_constraint,ConstraintSet.END)
        constraintSet.applyTo(mainConstraint)

        binding.botCard.visibility = View.VISIBLE
       // UiUtils.animation(this,binding.animViewMain,R.anim.slide_in_from_bottom,true)
        UiUtils.animation(this,binding.botCard,R.anim.slide_in_from_bottom,true)
    }

    private fun loadPage2(phone:String){
        page = 1
        binding.animViewMain.visibility = View.VISIBLE
        binding.top.visibility = View.VISIBLE
        binding.animViewTop.visibility = View.GONE
        binding.animViewSide.visibility = View.VISIBLE
        binding.back.visibility = View.VISIBLE
        binding.title.visibility = View.VISIBLE
        binding.botCard.visibility = View.VISIBLE
        binding.page1.visibility = View.GONE
        binding.page2.visibility = View.VISIBLE
        binding.page3.visibility = View.GONE
        loadSubPage1()
        binding.otpTopTxt.text = "To verify your phone number/mail, please enter the OTP sent to $phone."
        binding.otp1.text.clear()
        binding.otp2.text.clear()
        binding.otp3.text.clear()
        binding.otp4.text.clear()
        binding.otp5.text.clear()
        binding.otp6.text.clear()
        binding.otp1.requestFocus()

        binding.animViewMain.layoutParams.width = UiUtils.convertDpToPixel(160F,this).roundToInt()
        binding.animViewMain.layoutParams.height = UiUtils.convertDpToPixel(160F,this).roundToInt()
        val mainConstraint = binding.mainConstraint
        val constraintSet = ConstraintSet()
        constraintSet.clone(mainConstraint)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.TOP)
        constraintSet.connect(R.id.anim_view_main,ConstraintSet.TOP,R.id.anim_view_main,ConstraintSet.TOP)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.START)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.END)
        constraintSet.connect(R.id.anim_view_main,ConstraintSet.END,R.id.main_constraint,ConstraintSet.END)
        constraintSet.applyTo(mainConstraint)
        timer()
    }

    private fun loadSubPage1(){
        page = 2
        binding.subPage1.visibility = View.VISIBLE
        binding.subPage2.visibility = View.GONE
        binding.subPage3.visibility = View.GONE
        binding.subTitle.text = "1 of 3"
        binding.title.text = "Verify OTP"
        UiUtils.viewBgColor(binding.view1,null,R.color.colorPrimary)
        UiUtils.viewBgColor(binding.view2,"#E2E2E2",null)
        UiUtils.viewBgColor(binding.view3,"#E2E2E2",null)
    }
    private fun loadSubPage2(){
        page = 3
        binding.subPage1.visibility = View.GONE
        binding.subPage2.visibility = View.VISIBLE
        binding.subPage3.visibility = View.GONE
        binding.subTitle.text = "2 of 3"
        binding.title.text = "Create an Account"
        UiUtils.viewBgColor(binding.view1,null,R.color.colorPrimary)
        UiUtils.viewBgColor(binding.view2,null,R.color.colorPrimary)
        UiUtils.viewBgColor(binding.view3,"#E2E2E2",null)
    }
    private fun loadSubPage3(){
        page = 4
        binding.subPage1.visibility = View.GONE
        binding.subPage2.visibility = View.GONE
        binding.subPage3.visibility = View.VISIBLE
        binding.subTitle.text = "3 of 3"
        binding.title.text = "Intrest Topics"
        UiUtils.viewBgColor(binding.view1,null,R.color.colorPrimary)
        UiUtils.viewBgColor(binding.view2,null,R.color.colorPrimary)
        UiUtils.viewBgColor(binding.view3,null,R.color.colorPrimary)
    }

    private fun loadPage3(){
        page = 5
        binding.animViewMain.visibility = View.VISIBLE
        binding.top.visibility = View.VISIBLE
        binding.animViewTop.visibility = View.GONE
        binding.animViewSide.visibility = View.VISIBLE
        binding.back.visibility = View.VISIBLE
        binding.title.visibility = View.VISIBLE
        binding.botCard.visibility = View.VISIBLE
        binding.page1.visibility = View.GONE
        binding.page2.visibility = View.GONE
        binding.page3.visibility = View.VISIBLE
        binding.title.text = "Login"

        binding.animViewMain.layoutParams.width = UiUtils.convertDpToPixel(160F,this).roundToInt()
        binding.animViewMain.layoutParams.height = UiUtils.convertDpToPixel(160F,this).roundToInt()
        val mainConstraint = binding.mainConstraint
        val constraintSet = ConstraintSet()
        constraintSet.clone(mainConstraint)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.TOP)
        constraintSet.connect(R.id.anim_view_main,ConstraintSet.TOP,R.id.anim_view_main,ConstraintSet.TOP)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.START)
        constraintSet.clear(R.id.anim_view_main,ConstraintSet.END)
        constraintSet.connect(R.id.anim_view_main,ConstraintSet.END,R.id.main_constraint,ConstraintSet.END)
        constraintSet.applyTo(mainConstraint)
    }


    fun checkLogin(){
        if(sharedHelper.loggedIn && (sharedHelper.isBioMetric || sharedHelper.role == "GUEST")){
           // BaseUtils.startActivity(this@SplashActivity,AuthActivity(),null,true)
        }
        else if(sharedHelper.loggedIn){
            moveNext()
        }
        else{
            if(binding.top.visibility == View.GONE){
                //  binding.animViewMain.clearAnimation()
                //  binding.animViewMain.setAnimation("splash.json")
               // binding.animViewMain.playAnimation()
                loadPage1()
            }
        }
    }
    fun moveNext(){
        binding.animViewMain.cancelAnimation()
        val bundle = Bundle()
       // bundle.putBoolean("isGuest",isGuest)
        BaseUtils.startActivity(this@SplashActivity,DashBoardActivity(),bundle,true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       // callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("fghjk",""+requestCode+".."+resultCode+".."+data)
        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                sharedHelper.isBioMetric = true
                //UiUtils.imageViewTint(binding.anim_view_mainFinger,null,R.color.green)
                moveNext()
            }
        }
        else if(requestCode == SMS_CONSENT_REQUEST) {
            if (resultCode == RESULT_OK && data != null) {
                val msg = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)
                getOtpFromMsg(msg.toString())
            }
            else{
                UiUtils.showSnack("Could not auto-verify otp, please enter it.",binding.root)
            }
        }
        else if(requestCode == RC_SIGN_IN && resultCode== Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                account.idToken?.let {
                   // loginViewModel.updateAuthTokenFromServer("Google", it)
                   // binding.pbLoading.visibility = View.INVISIBLE
                }
            }
            catch (e: ApiException) {
                Toast.makeText(this, "Exception $e", Toast.LENGTH_SHORT).show()
               // binding.pbLoading.visibility = View.INVISIBLE
            }
        }
    }

    private fun getOtpFromMsg(msg: String) {
        if (msg.contains("Dr.M.G.R")) {
            val otp = msg.filter { it.isDigit() }
            binding.otp1.setText(otp[0].toString())
            binding.otp2.setText(otp[1].toString())
            binding.otp3.setText(otp[2].toString())
            binding.otp4.setText(otp[3].toString())
            binding.otp5.setText(otp[4].toString())
            binding.otp6.setText(otp[5].toString())
           // verifyOtp(otp)
        }
        else {
            UiUtils.showSnack("Could not auto-verify otp, please enter it.",binding.root)
        }
    }

    override fun onStart() {
        super.onStart()
        /*val intentFilter = IntentFilter().apply {
            addAction(SmsRetriever.SMS_RETRIEVED_ACTION)
        }
        registerReceiver(smsRetriever, intentFilter)*/
       // registerBroadcastReceiver()
    }

    override fun onStop() {
        try{
           // unregisterReceiver(smsRetriever)
        } catch (e: Exception){
        }
        super.onStop()
    }

    private fun startSmsUserConsent() {
        val client = SmsRetriever.getClient(this)
        client.startSmsUserConsent(null).addOnSuccessListener {}.addOnFailureListener {}
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun hari(){
       // val random: SecureRandom = SecureRandom()
       // val EncryptionKey = ByteArray(16)
       // random.nextBytes(EncryptionKey)

        val x = "662ede816988e58fb6d057d9d85605e0"
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val secretKey:String = x.substring(0,12)+"$hour"+x.substring(12,x.length-2)

        Log.d("vbn0",""+secretKey)

        try {
            val text = "918870927538"
            val encrypt = encrypt(text, secretKey)
            Log.d("vbn1",""+encrypt)

             val decrypt: String = decrypt(encrypt, secretKey)
            Log.d("vbn3",""+decrypt)
        }
        catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}