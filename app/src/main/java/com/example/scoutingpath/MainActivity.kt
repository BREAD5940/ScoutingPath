package com.example.scoutingpath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        // code from https://xjaphx.wordpress.com/2011/06/13/detect-xy-coordinates-when-clicking-or-touching-on-screen/
        // and https://stackoverflow.com/questions/3294590/set-the-absolute-position-of-a-view
        // and a lot of other places on the internet
        if (event.action == MotionEvent.ACTION_DOWN) {
            val x = event.x
            val y = event.y
            xy.setText("X: " + x + " Y: " + y)
            val layout  = R.layout.activity_main
            var iv: ImageView
            iv = ImageView(this)
            c.addView(iv)
            iv.x = x
            iv.y = y - 180 // no clue why in the name of Android this is needed, but it is...
            iv.layoutParams.height = 10
            iv.layoutParams.width = 10
            iv.setBackgroundColor(Color.RED)

        }
        return super.onTouchEvent(event)
    }

}
