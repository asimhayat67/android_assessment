package com.example.senthil.kotlin_navigationdrawer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.senthil.kotlin_navigationdrawer.R
import com.example.senthil.kotlin_navigationdrawer.data.ExpandableItem

class OuterAdapter(private val items: List<ExpandableItem>, private val context: Context) :
    RecyclerView.Adapter<OuterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_outer, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleTextView.text = currentItem.title

        val innerAdapter = InnerAdapter(currentItem.children)
        holder.innerRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = innerAdapter
        }
        if (currentItem.isExpended) {
            holder.ivArrow.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.arrow_down_icon
                )
            )
        } else {
            holder.ivArrow.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.arrow_up_icon
                )
            )
        }

        holder.parentLayout.setOnClickListener {
            currentItem.isExpended = !currentItem.isExpended
            notifyItemChanged(position)
        }

        holder.innerRecyclerView.visibility = if (currentItem.isExpended) {
            View.VISIBLE
        } else {
            View.GONE
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val innerRecyclerView: RecyclerView = itemView.findViewById(R.id.innerRecyclerView)
        val parentLayout: RelativeLayout = itemView.findViewById(R.id.parentLayout)
        val ivArrow: ImageView = itemView.findViewById(R.id.ivArrow)
    }
}