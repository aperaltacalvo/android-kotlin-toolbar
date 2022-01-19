package com.example.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), ToolbarFragment.ToolbarListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButonClick(position: Int, text: String) {
        val textFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as TextFragment
        textFragment.changeTextProperties(position, text)
    }
}