package com.aim.demo

import android.app.Dialog
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.dr.mgr.session.Constants.ApplicationConstants.SOCKET_BASE_URL
import com.dr.mgr.session.SharedHelper
import com.dr.mgr.utils.BaseUtils
import com.dr.mgr.utils.UiUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.reactivex.disposables.CompositeDisposable
import io.socket.client.Ack
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONObject
import java.net.URISyntaxException

open class BaseActivity : AppCompatActivity() {
    companion object {
        val mObjectMapper: ObjectMapper by lazy {
            ObjectMapper()
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        }
    }
    var mToast: Toast? = null
    var mHashIdentifier = ""
    var mCustomDialog: AlertDialog? = null
    var mCompositeDisposable = CompositeDisposable()
    lateinit var sharedHelper: SharedHelper
    lateinit var view: View
    /*var requestCode = 0
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
        }
    }*/


//    val activityLauncher: BetterActivityResult<Intent, ActivityResult> by lazy { BetterActivityResult.registerActivityForResult(this) }
     var mSocket: Socket? = null
    var reportDialog: BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbarUpView()
        //mDataBaseHandler = DatabaseHelper(this)
        sharedHelper = SharedHelper(this)
        initSocket()
       /* if(SocketHandler.getSocket() == null){
            initSocket()
        }
        else{
            mSocket = SocketHandler.getSocket()
        }*/
    }

    fun apiDetailsShown(){

    }

    fun initSocket(){
        /*  val options = IO.Options()
          options.forceNew = true
          options.reconnection = false
          options.path = "/ws";
          options.reconnectionAttempts = 1
          options.transports = arrayOf(WebSocket.NAME) //or Polling.NAME
          options.reconnectionDelay = 2000
          options.reconnectionDelayMax = 5000
  */


      /*  SocketHandler.setSocket()
        SocketHandler.establishConnection()
        mSocket = SocketHandler.getSocket()*/

        try {
            mSocket = IO.socket(SOCKET_BASE_URL)
            mSocket.let {
                if(!it!!.connected()){
                    mSocket!!.connect()
                }
            }
        } catch (e: URISyntaxException) {
            throw RuntimeException(e)
        }



        mSocket!!.on(Socket.EVENT_DISCONNECT){
            Log.d("Socket","DisConnected")
            // initSocket()
        }
        mSocket!!.on(Socket.EVENT_CONNECT){
            Log.d("Socket","Connected")
            //  initSocket()
        }
        mSocket!!.on(Socket.EVENT_CONNECT_ERROR){
            Log.d("Socket","Error"+it[0].toString())
            //  initSocket()
        }

        val jsonObject = JSONObject()
        jsonObject.put("username",sharedHelper.name)
        jsonObject.put("user_id",sharedHelper.id)
        mSocket!!.emit("connect-me", jsonObject,object : Ack {
            override fun call(vararg args: Any?) {
                Log.d("vnnv9", "....$args")
            }
        })
        mSocket!!.on("user-connected") {
            UiUtils.showLog(" listener ", it[0].toString())
        }
        mSocket!!.on("user-disconnect") {
            UiUtils.showLog(" listener ", it[0].toString())
        }
    }

    fun removeSocket(){
        if(mSocket != null){
            mSocket!!.emit("disconnect", null,object : Ack {
                override fun call(vararg args: Any?) {
                    Log.d("vnnv9", "....$args")
                }
            })
            mSocket!!.disconnect()
        }
    }

    open fun setToolbarUpView() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
    }

    override fun onResume() {
        super.onResume()
        BaseUtils.hideKeyboard(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }



}