package com.otto.paulus.hellokotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.otto.paulus.hellokotlin.Item
import com.otto.paulus.hellokotlin.anko.ListItemUI
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ListItemUI().createView(AnkoContext.create(context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            val name = itemView.findViewById<TextView>(ListItemUI.name)
            val image = itemView.findViewById<ImageView>(ListItemUI.image)

            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}