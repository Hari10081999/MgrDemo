package com.dr.mgr_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.dr.mgr_library.databinding.ActivityAddContentBinding

class AddContentActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_content)

        val staticFields = arrayOf("Option 1", "Option 2", "Option 3")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, staticFields)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter
    }
}