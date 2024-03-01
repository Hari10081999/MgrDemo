package com.dr.mgr_library.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dr.mgr_library.R
import com.dr.mgr_library.VideoActivity

class CategoryVideoAdater(private val videoItems: ArrayList<String>,var activity: Activity) : RecyclerView.Adapter<CategoryVideoAdater.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define views inside ViewHolder if needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(activity, VideoActivity::class.java)
            intent.putExtra("videoUrl", "")
            activity.startActivity(intent)
        }
        // Bind other data to ViewHolder
    }

    override fun getItemCount(): Int {
        return 5
    }
}