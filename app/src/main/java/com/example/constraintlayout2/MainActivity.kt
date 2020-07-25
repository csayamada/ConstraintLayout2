package com.example.constraintlayout2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.viewControlled).addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            val p = v.parent as? View ?: return@addOnLayoutChangeListener
            val parentWidth = p.width
            val parentHeight = p.height
            val rightWidth = parentWidth - right
            val bottomHeight = parentHeight - bottom
            val spaceWidth = (left + rightWidth).toFloat()
            findViewById<TextView>(R.id.txtLeftWidth).text =
                getString(R.string.position_proportion, left, left / spaceWidth)
            val spaceHeight = (top + bottomHeight).toFloat()
            findViewById<TextView>(R.id.txtTopHeight).text =
                getString(R.string.position_proportion, top, top / spaceHeight)
            findViewById<TextView>(R.id.txtRightWidth).text =
                getString(R.string.position_proportion, rightWidth, rightWidth / spaceWidth)
            findViewById<TextView>(R.id.txtBottomHeight).text =
                getString(R.string.position_proportion, bottomHeight, bottomHeight / spaceHeight)
        }
    }
}
