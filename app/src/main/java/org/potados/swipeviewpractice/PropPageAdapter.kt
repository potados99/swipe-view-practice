package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.the_page.view.*
import kotlin.math.ceil
import kotlin.math.min

class PropPageAdapter(
    private val propPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool(),
    private val stackSize: Int = 3,
) : RecyclerView.Adapter<PropPageAdapter.PropPageViewHolder>() {

    var wholeProps: List<String> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropPageViewHolder {
        Reporter.outer.report()

        return PropPageViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PropPageViewHolder, position: Int) {
        fun paginateProps(pageNumber: Int): List<String> {
            val indexStart = pageNumber * stackSize
            val indexEnd = min(indexStart + stackSize - 1, wholeProps.size - 1)

            return wholeProps.slice(indexStart..indexEnd)
        }

        holder.bind(paginateProps(position))
    }

    override fun getItemCount(): Int {
        return ceil(wholeProps.size.toDouble()/stackSize).toInt()
    }

    inner class PropPageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_page, parent, false))

        private val propAdapter = PropAdapter()

        init {
            setChildRecyclerView()
        }

        private fun setChildRecyclerView() {
            with(itemView.the_prop_recycler) {
                adapter = propAdapter

                setRecycledViewPool(propPool)
                (layoutManager as LinearLayoutManager).recycleChildrenOnDetach = true
            }
        }

        fun bind(pagedProps: List<String>) {
            propAdapter.pagedProps = pagedProps
        }
    }
}