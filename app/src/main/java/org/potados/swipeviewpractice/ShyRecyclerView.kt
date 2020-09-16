package org.potados.swipeviewpractice

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.tan

class ShyRecyclerView(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs) {

    private val gestureDetector = GestureDetector(context, YScrollDetector())

    // Pass scroll event to child view if scroll angle lower than this.
    private val verticalScrollThresholdAngleDegree = 45.0
    private val diffRatioThreshold = tan(Math.toRadians(verticalScrollThresholdAngleDegree))

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(e) && e != null && gestureDetector.onTouchEvent(e)
    }

    inner class YScrollDetector : SimpleOnGestureListener() {
        // Return false if scroll angle low
        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            return abs(distanceY) / abs(distanceX) > diffRatioThreshold
        }
    }
}