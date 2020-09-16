package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.the_stack.view.*
import kotlin.math.ceil
import kotlin.math.min

class ThePropStackPagerAdapter(
    private val pool: RecyclerView.RecycledViewPool,
    var stackSize: Int = 3,
) : RecyclerView.Adapter<ThePropStackPagerAdapter.TheViewHolder>() {

    var items: List<String> = arrayListOf()

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

    inner class TheViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_stack, parent, false))

        init {
            with(itemView.the_prop_recycler) {
                setRecycledViewPool(pool)
                (layoutManager as LinearLayoutManager).recycleChildrenOnDetach = true
            }
        }

        private val theAdapter = ThePropRecyclerAdapter().also {
            itemView.the_prop_recycler.adapter = it
        }

        fun bind(contents: List<String>) {
            with(theAdapter) {
                props = contents
                notifyDataSetChanged()
            }
        }
    }
}