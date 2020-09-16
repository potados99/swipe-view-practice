package org.potados.swipeviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.the_section.view.*

class SectionAdapter : RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    private val propStackPool = RecyclerView.RecycledViewPool()
    private val propPool = RecyclerView.RecycledViewPool()

    var sections: List<String> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder(parent)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(sections[position])
    }

    override fun getItemCount(): Int {
        return sections.size
    }

    inner class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.the_section, parent, false))

        private val propStackAdapter = PropPageAdapter(propPool)

        init {
            setChildRecyclerView()
        }

        private fun setChildRecyclerView() {
            with(itemView.the_prop_stack_recycler) {
                adapter = propStackAdapter

                setRecycledViewPool(propStackPool)
                (layoutManager as LinearLayoutManager).recycleChildrenOnDetach = true

                PagerSnapHelper().attachToRecyclerView(this)
            }
        }

        fun bind(content: String) {
            with(itemView) {
                section_name.text = content

                more_button.setOnClickListener {
                    Toast.makeText(context, "Not implemented!", Toast.LENGTH_SHORT).show()
                }
            }

            propStackAdapter.wholeProps = listOf("Hello", "World", "Lorem", "Ipsum", "Dolor")
        }
    }
}