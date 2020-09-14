package org.potados.swipeviewpractice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.the_item.view.*

class TheAdapter(
    private val items: List<String> = arrayListOf()
) : RecyclerView.Adapter<TheAdapter.TheViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        return TheViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TheViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_item, parent, false))

        fun bind(content: String) {
            view.the_text.text = content

            view.item_root.setOnClickListener {

                view.item_root.layoutParams = (view.item_root.layoutParams as ViewGroup.MarginLayoutParams).apply {

                    if (topMargin == 0) {
                        topMargin = 229
                        bottomMargin = 229
                        leftMargin = 229
                        rightMargin = 229
                    } else {
                        topMargin = 0
                        bottomMargin = 0
                        leftMargin = 0
                        rightMargin = 0
                    }
                }
            }

        }
    }
}