package com.dr.mgr_library.fragment

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.UnderlineSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.e_library.adapter.VideoAdapter
import com.dr.mgr.session.Constants
import com.dr.mgr.session.SharedHelper
import com.dr.mgr.utils.BaseUtils
import com.dr.mgr.utils.UiUtils
import com.dr.mgr_library.DashBoardActivity
import com.dr.mgr_library.R
import com.dr.mgr_library.adapter.CategoryVideoAdater
import com.dr.mgr_library.adapter.categoryAdapter
import com.dr.mgr_library.databinding.FragmentHomeBinding
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import org.jetbrains.anko.support.v4.runOnUiThread
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var mActivity: DashBoardActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        mActivity = activity as DashBoardActivity
//        mActivity.selectBottomNav(0)

        val recyclerView: RecyclerView = binding.previousPlayed
        recyclerView.layoutManager = LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = VideoAdapter(mActivity.createVideoList(),mActivity)

        val recyclerView1: RecyclerView = binding.categories
        recyclerView1.layoutManager = LinearLayoutManager(mActivity,LinearLayoutManager.HORIZONTAL,false)
        recyclerView1.adapter = categoryAdapter(ArrayList(),mActivity)

        val recyclerView2: RecyclerView = binding.categoryWiseVideos
        recyclerView2.layoutManager = LinearLayoutManager(mActivity,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.adapter = CategoryVideoAdater(ArrayList(),mActivity)

        return view
    }
}