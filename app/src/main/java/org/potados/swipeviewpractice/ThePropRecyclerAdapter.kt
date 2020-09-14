package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.the_prop.view.*

class ThePropRecyclerAdapter(
    private val props: List<String> = listOf()
) : RecyclerView.Adapter<ThePropRecyclerAdapter.TheViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        return TheViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        holder.bind(props[position])
    }

    override fun getItemCount(): Int {
        return props.size
    }

    class TheViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_prop, parent, false))

        fun bind(content: String) {
            with(itemView) {
                prop_symbol.text = content
                prop_name.text = content
            }
        }
    }
}