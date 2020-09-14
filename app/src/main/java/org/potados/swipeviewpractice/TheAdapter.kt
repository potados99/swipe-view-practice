package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    class TheViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_item, parent, false))

        fun bind(content: String) {
            with(itemView) {
                section_name.text = content
                with(the_card_swiper_pager) {
                    adapter = TheCardSwiperAdapter(listOf("Hello", "World", "Lorem", "Ipsum", "Dolor"))
                    offscreenPageLimit = 3

                    // Space between pages.
                    val pageSpacePx = resources.getDimensionPixelOffset(R.dimen.page_space)

                    // The margin applied to the item view.
                    val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.page_margin)

                    setPageTransformer(ThePageTransformer(pageSpacePx, pageMarginPx))
                }
            }
        }
    }
}