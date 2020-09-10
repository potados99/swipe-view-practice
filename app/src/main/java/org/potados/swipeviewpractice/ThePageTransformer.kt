package org.potados.swipeviewpractice

import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class ThePageTransformer(
    private val pageSpacePx: Int,
    private val pageMarginPx: Int
) : ViewPager2.PageTransformer {

    private val TAG = "ThePageTransformer"

    init {
        Log.i(TAG, "Initializing with pageSpacePx: ${pageSpacePx}, pageMarginPx: ${pageMarginPx}.")
    }

    override fun transformPage(page: View, position: Float) {
        val offset = position * -(2 * pageMarginPx - pageSpacePx)

        Log.i(TAG, "position: ${position}, offset ${offset}.")

        page.translationX = offset

        val transformRange = 0.3f

        if (abs(position) < transformRange) {
            page.scaleX = scaleFormula(1.0f, 0.5f, transformRange, position)
            page.scaleY = scaleFormula(1.0f, 0.5f, transformRange, position)
        } else {
            page.scaleX = 0.5f
            page.scaleY = 0.5f
        }
    }

    private fun scaleFormula(maxScale: Float, minScale: Float,transformRange: Float, position: Float): Float {
        return maxScale - abs(position)*(maxScale - minScale)/(transformRange)
    }
}