package com.example.scoutingpath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo
import android.widget.Toast
import android.view.MotionEvent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        // code from https://xjaphx.wordpress.com/2011/06/13/detect-xy-coordinates-when-clicking-or-touching-on-screen/
        if (event.action == MotionEvent.ACTION_DOWN) {
            val x = event.x
            val y = event.y
            xy.setText("X: " + x + " Y: " + y)
        }
        return super.onTouchEvent(event)
    }

}
