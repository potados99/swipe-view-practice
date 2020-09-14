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
    }

    private fun setAdapter() {
        with(the_recyclerView) {
            adapter = TheAdapter(listOf("One", "Two", "Three", "Four", "Five"))
        }
    }
}