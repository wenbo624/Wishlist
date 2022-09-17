package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class listAdapter(
    private val wish: MutableList<Item>
) :RecyclerView.Adapter<listAdapter.wishlistViewHolder>(){

    class wishlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.nameTV)
            priceTextView = itemView.findViewById(R.id.PriceTV)
            urlTextView = itemView.findViewById(R.id.urlTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): wishlistViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return wishlistViewHolder(

            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )
    }

    fun addwish(item: Item) {
        wish.add(item)
        notifyItemInserted(wish.size - 1)
    }

    override fun onBindViewHolder(holder: wishlistViewHolder, position: Int) {
        // Get the data model based on position
        val curitem = wish.get(position)
        // Set item views based on views and data model
        holder.nameTextView.text = curitem.name
        holder.priceTextView.text = curitem.price.toString()
        holder.urlTextView.text = curitem.url
    }

    override fun getItemCount(): Int {
        return wish.size
    }
}