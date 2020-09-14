package org.potados.swipeviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSectionRecyclerView()
    }

    private fun setSectionRecyclerView() {
        with(the_section_recycler) {
            adapter = TheSectionRecyclerAdapter(listOf("One", "Two", "Three", "Four", "Five"))
        }
    }
}