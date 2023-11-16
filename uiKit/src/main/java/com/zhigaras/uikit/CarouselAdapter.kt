package com.zhigaras.uikit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CarouselAdapter(private val list: List<String>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {
    
    class CarouselViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        
        fun bind(item: String) {
            view.findViewById<ImageView>(R.id.image).glideLoad(item)
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        return CarouselViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.carousel_image_item, parent, false)
        )
    }
    
    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }
    
    override fun getItemCount() = list.size
}