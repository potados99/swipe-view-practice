package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.the_stack.view.*
import kotlin.math.ceil
import kotlin.math.min

class ThePropStackPagerAdapter(
    private val items: List<String> = arrayListOf(),
    private val stackSize: Int = 3,
) : RecyclerView.Adapter<ThePropStackPagerAdapter.TheViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        return TheViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        val indexStart = position * stackSize
        val indexEnd = min(indexStart + stackSize - 1, items.size - 1)

        holder.bind(items.slice(indexStart..indexEnd))
    }

    override fun getItemCount(): Int {
        return ceil(items.size.toDouble()/stackSize).toInt()
    }

    class TheViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_stack, parent, false))

        fun bind(contents: List<String>) {
            with(itemView) {
                the_prop_recycler.adapter = ThePropRecyclerAdapter(contents)
            }
        }
    }
}