package org.potados.swipeviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSectionRecyclerView()
    }

    private fun setSectionRecyclerView() {
        val pool = RecyclerView.RecycledViewPool()

        with(the_section_recycler) {
            adapter = TheSectionRecyclerAdapter(pool).apply {
                items = listOf(
                    "One", "Two", "Three", "Four",
                    "Five", "Six", "Seven", "Eight",
                    "Nine", "Ten", "Eleven", "Twelve",
                    "Thirteen", "Fourteen", "Fifteen", "Sixteen"
                )

                notifyDataSetChanged()
            }
        }
    }
}