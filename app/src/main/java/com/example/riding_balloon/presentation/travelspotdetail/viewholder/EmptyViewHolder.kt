package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import android.util.Log
import com.example.riding_balloon.databinding.LayoutItemTravelEmptyBinding

class EmptyViewHolder(binding: LayoutItemTravelEmptyBinding) : TravelViewHolder(binding) {
    override fun bind() {
        Log.d("ViewHolder 체크", "Empty")
    }
}