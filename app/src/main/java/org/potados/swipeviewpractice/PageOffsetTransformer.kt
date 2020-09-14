package org.potados.swipeviewpractice

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class PageOffsetTransformer(
    private val pageSpacePx: Int,
    private val pageMarginPx: Int
) : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        val offset = position * -(2*pageMarginPx - pageSpacePx)

        page.translationX = offset
    }
}