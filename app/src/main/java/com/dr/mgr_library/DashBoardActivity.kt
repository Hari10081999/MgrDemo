package com.dr.mgr_library

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dr.mgr_library.databinding.ActivityDashBoardBinding
import com.android.e_library.adapter.VideoAdapter
import com.android.e_library.model.VideoItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import com.android.e_library.fragment.BookFragment
import com.android.e_library.fragment.LibraryFragment
import com.android.e_library.fragment.ProfileFragment
import com.dr.mgr.utils.BaseUtils
import com.dr.mgr_library.adapter.CategoryVideoAdater
import com.dr.mgr_library.adapter.categoryAdapter
import com.dr.mgr_library.fragment.HomeFragment
import com.piechips.user.models.FragmentModel

class DashBoardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashBoardBinding
    lateinit var fragmentTransaction: FragmentTransaction
    var fragArray: ArrayList<FragmentModel> = ArrayList()
    var homefragment: HomeFragment = HomeFragment()
    var libraryFragment: LibraryFragment = LibraryFragment()
    var bookFragment:BookFragment = BookFragment()
    var profileFragment:ProfileFragment = ProfileFragment()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(homefragment, null,0)

        binding.imgHome.setOnClickListener {
            addFragment(homefragment, null,0)
        }

        binding.imgChat.setOnClickListener {
            addFragment(libraryFragment, null,1)
        }

        binding.vector.setOnClickListener{
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("videoUrl", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            startActivity(intent)
        }

        binding.imgList.setOnClickListener {
            addFragment(bookFragment, null,3)
        }

        binding.imgSetting.setOnClickListener {
            addFragment(profileFragment, null,4)
        }
    }

    fun addFragment(fragment: Fragment, bundle: Bundle?, bnavid: Int){
        if(!fragment.isVisible){
            BaseUtils.hideForceKeyboard(binding.root)
            fragArray.add(fragArray.size,FragmentModel(bnavid,fragment))
            fragment.arguments = bundle
            fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragment,fragment.javaClass.name)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
    fun createVideoList(): List<VideoItem> {
        val videoList = mutableListOf<VideoItem>()
        videoList.add(
            VideoItem(
                "Video 1",
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            )
        )
        videoList.add(
            VideoItem(
                "Video 2",
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
            )
        )
        videoList.add(
            VideoItem(
                "Video 3",
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
            )
        )
        videoList.add(
            VideoItem(
                "Video 4",
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
            )
        )
        return videoList
    }

    override fun onBackPressed() {
        if(homefragment.isVisible){
           // super.onBackPressed()
            finish()
        }
        else{
            addFragment(homefragment, null,0)
        }
    }
}
