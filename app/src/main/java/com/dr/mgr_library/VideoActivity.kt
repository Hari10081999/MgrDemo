package com.dr.mgr_library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dr.mgr_library.databinding.DetailListBinding
import com.android.e_library.adapter.VideoAdapter
import com.android.e_library.model.VideoItem
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.util.MimeTypes

class VideoActivity : AppCompatActivity() {
    lateinit var binding: DetailListBinding
    private var player: ExoPlayer? = null
    private val isPlaying get() = player?.isPlaying ?: false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoUrl = intent.getStringExtra("videoUrl") ?: return

        initializePlayer(videoUrl)

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

    private fun initializePlayer(videoUrl: String) {
        player = ExoPlayer.Builder(this) // <- context
            .build()

        // create a media item.
        val mediaItem = MediaItem.Builder()
            .setUri(videoUrl)
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()

        // Create a media source and pass the media item
        val mediaSource = ProgressiveMediaSource.Factory(
            DefaultDataSource.Factory(this) // <- context
        )
            .createMediaSource(mediaItem)

        // Finally assign this media source to the player
        player!!.apply {
            setMediaSource(mediaSource)
            playWhenReady = true // start playing when the exoplayer has setup
            seekTo(0, 0L) // Start from the beginning
            prepare() // Change the state from idle.
        }.also {
            // Do not forget to attach the player to the view
            binding.playerView.player = it
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        player!!.release()
    }
}
