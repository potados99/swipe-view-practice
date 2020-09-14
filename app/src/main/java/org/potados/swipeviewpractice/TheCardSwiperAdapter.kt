package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.the_card.view.*
import java.lang.Integer.min

class TheCardSwiperAdapter(
    private val items: List<String> = arrayListOf()
) : RecyclerView.Adapter<TheCardSwiperAdapter.TheViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        return TheViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        holder.bind(items.slice(position*3..(min(position*3 + 2, items.size - 1))))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TheViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_card, parent, false))

        fun bind(contents: List<String>) {
            with(itemView) {
                the_prop_stack.adapter = ThePropAdapter(contents)
            }
        }
    }
}