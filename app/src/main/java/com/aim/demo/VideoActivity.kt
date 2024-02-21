package com.aim.demo

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.exoplayer.ExoPlayer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aim.demo.databinding.ActivityDashBoardBinding
import com.aim.demo.databinding.DetailListBinding
import com.android.e_library.adapter.VideoAdapter
import com.android.e_library.model.VideoItem
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class VideoActivity : AppCompatActivity() {
    lateinit var binding: DetailListBinding
    private lateinit var player: SimpleExoPlayer
    private lateinit var playerView: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playerView = findViewById(R.id.videoUrl)
        val videoUrl = intent.getStringExtra("videoUrl") ?: return

        player = SimpleExoPlayer.Builder(this).build()
        playerView.player = player

        val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()

        binding.back.setOnClickListener{
            finish()
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewItems)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = VideoAdapter(createVideoList(),this)
    }

    private fun createVideoList(): List<VideoItem> {
        val videoList = mutableListOf<VideoItem>()
        videoList.add(
            VideoItem(
                "Video 1",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            )
        )
        videoList.add(
            VideoItem(
                "Video 2",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
            )
        )
        return videoList
    }



    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
