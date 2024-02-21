package com.android.e_library.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aim.demo.DashBoardActivity
import com.aim.demo.R
import com.aim.demo.VideoActivity
import com.android.e_library.model.VideoItem

class VideoAdapter(private val videoItems: List<VideoItem>, private val activity: Activity) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define views inside ViewHolder if needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.progress_card_single, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videoItem = videoItems[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(activity, VideoActivity::class.java)
            intent.putExtra("videoUrl", videoItem.videoUrl)
            activity.startActivity(intent)
        }

        // Bind other data to ViewHolder
    }

    override fun getItemCount(): Int {
        return videoItems.size
    }

    interface OnItemClickListener {
        fun onItemClick(videoItem: VideoItem)
    }




    // ViewHolder class and other methods
}
