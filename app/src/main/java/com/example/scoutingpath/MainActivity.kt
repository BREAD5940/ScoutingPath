package com.example.scoutingpath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.view.MotionEvent
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {
    var X_OFFSET = 0
    var Y_OFFSET = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        // code from https://xjaphx.wordpress.com/2011/06/13/detect-xy-coordinates-when-clicking-or-touching-on-screen/
        // and https://stackoverflow.com/questions/3294590/set-the-absolute-position-of-a-view
        // and a lot of other places on the internet
        if (event.action == MotionEvent.ACTION_DOWN) { // It's a tap
            // Compute x,y offsets
            var location = IntArray(size=2)
            fieldImage.getLocationOnScreen(location);
            print(location)
            X_OFFSET = location[0] + 102 // X offset so that x,y are relative to the field.
            // 102 for the width of the off-field part of fieldImage
            Y_OFFSET = location[1] + 26 + 32 // Y offset so that x,y are relative to the field
            // magic numbers zzzz
            val x = event.x - X_OFFSET// Correct for the field image placement
            val y = event.y - Y_OFFSET

            xy.setText("X: " + x + " Y: " + y +" " + X_OFFSET + "/" + Y_OFFSET) // update debug x,y

            val layout  = R.layout.activity_main //
            var iv: ImageView
            iv = ImageView(this)
            c.addView(iv)
            iv.x = event.x // event.x is a screen coordinate, whereas x is a corrected field coordinate.
            iv.y = event.y - 100 // no clue why in the name of Android this is needed, but it is...
            iv.layoutParams.height = 10
            iv.layoutParams.width = 10
            iv.setBackgroundColor(Color.RED)

        }
        return super.onTouchEvent(event)
    }

}
