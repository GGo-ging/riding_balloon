package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.riding_balloon.presentation.travelspotdetail.UiModel

abstract class TravelViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: UiModel)
}