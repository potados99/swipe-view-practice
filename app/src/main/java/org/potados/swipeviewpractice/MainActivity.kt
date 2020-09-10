package org.potados.swipeviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.Preconditions
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
        setSidePreview()
    }

    private fun setAdapter() {
        with(the_pager) {
            adapter = TheAdapter(listOf("One", "Two", "Three"))
        }
    }

    private fun setSidePreview() {
        with(the_pager) {
            offscreenPageLimit = 3

            // Space between pages.
            val pageSpacePx = resources.getDimensionPixelOffset(R.dimen.page_space)

            // The margin applied to the item view.
            val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.page_margin)

            setPageTransformer(ThePageTransformer(pageSpacePx, pageMarginPx))
        }
    }
}