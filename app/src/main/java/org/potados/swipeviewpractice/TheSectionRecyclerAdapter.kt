package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.the_section.view.*

class TheSectionRecyclerAdapter() : RecyclerView.Adapter<TheSectionRecyclerAdapter.TheViewHolder>() {

    private val propStackPool = RecyclerView.RecycledViewPool()
    private val propPool = RecyclerView.RecycledViewPool()

    var items: List<String> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        return TheViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class TheViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_section, parent, false))

        init {
            // setTransformer(itemView.the_prop_stack_pager)

            with(itemView.the_prop_stack_recycler) {

                PagerSnapHelper().attachToRecyclerView(this)

                with(layoutManager as LinearLayoutManager) {
                    setRecycledViewPool(propStackPool)
                    recycleChildrenOnDetach = true
                }
            }
        }

        private val theAdapter = ThePropStackRecyclerAdapter(propPool).also {
            itemView.the_prop_stack_recycler.adapter = it
        }

        fun bind(content: String) {
            with(itemView) {
                section_name.text = content

                with(theAdapter) {
                    items = listOf("Hello", "World", "Lorem", "Ipsum", "Dolor")
                    notifyDataSetChanged()
                }
            }
        }

        private fun setTransformer(pager: ViewPager2) {
            with(pager) {
                // Pre-load side pages.
                offscreenPageLimit = 1

                val pageSpacePx = resources.getDimensionPixelOffset(R.dimen.page_space)
                val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.page_margin)

                setPageTransformer(PageOffsetTransformer(pageSpacePx, pageMarginPx))
            }
        }
    }
}