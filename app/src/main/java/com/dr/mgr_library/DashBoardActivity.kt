package com.dr.mgr_library

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import com.dr.mgr_library.adapter.CategoryVideoAdater
import com.dr.mgr_library.adapter.categoryAdapter

class DashBoardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashBoardBinding
    private lateinit var navHostFragment: NavHostFragment
    var navView: BottomNavigationView? = null
    var navController: NavController? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_container_main)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_chat,
            R.id.navigation_forum,
            R.id.navigation_settings
        ))
        NavigationUI.setupWithNavController(binding.navView, navController!!)

        val recyclerView: RecyclerView = findViewById(R.id.previousPlayed)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = VideoAdapter(createVideoList(),this)

        val recyclerView1: RecyclerView = findViewById(R.id.categories)
        recyclerView1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView1.adapter = categoryAdapter(ArrayList(),this)

        val recyclerView2: RecyclerView = findViewById(R.id.categoryWiseVideos)
        recyclerView2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.adapter = CategoryVideoAdater(ArrayList(),this)

        binding.vector.setOnClickListener{
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("videoUrl", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            startActivity(intent)
        }
    }

    private fun createVideoList(): List<VideoItem> {
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
}
