package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
            itemView.the_text.text = content
        }
    }
}