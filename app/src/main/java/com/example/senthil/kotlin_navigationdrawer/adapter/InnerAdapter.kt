package com.example.senthil.kotlin_navigationdrawer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.senthil.kotlin_navigationdrawer.R

class InnerAdapter(private val children: List<String>) :
    RecyclerView.Adapter<InnerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_inner, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = children[position]
        holder.childTextView.text = currentItem

    }

    override fun getItemCount(): Int {
        return children.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val childTextView: TextView = itemView.findViewById(R.id.childTextView)

    }
}