package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.the_section.view.*

class TheSectionRecyclerAdapter(
    private val items: List<String> = arrayListOf()
) : RecyclerView.Adapter<TheSectionRecyclerAdapter.TheViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        return TheViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TheViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_section, parent, false))

        fun bind(content: String) {
            with(itemView) {
                section_name.text = content

                with(the_prop_stack_pager) {
                    adapter = ThePropStackPagerAdapter(listOf("Hello", "World", "Lorem", "Ipsum", "Dolor"))

                    setTransformer(this)
                }
            }
        }

        private fun setTransformer(pager: ViewPager2) {
            with(pager) {
                // Pre-load side pages.
                offscreenPageLimit = 3

                val pageSpacePx = resources.getDimensionPixelOffset(R.dimen.page_space)
                val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.page_margin)

                setPageTransformer(PageOffsetTransformer(pageSpacePx, pageMarginPx))
            }
        }
    }
}