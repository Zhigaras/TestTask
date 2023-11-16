package com.zhigaras.uikit

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CarouselAdapter(private val list: List<String>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {
    
    class CarouselViewHolder(private val view: ImageView) : RecyclerView.ViewHolder(view) {
        
        fun bind(item: String) {
            // TODO: bind
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        return CarouselViewHolder(ImageView(parent.context))
    }
    
    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }
    
    override fun getItemCount() = list.size
}