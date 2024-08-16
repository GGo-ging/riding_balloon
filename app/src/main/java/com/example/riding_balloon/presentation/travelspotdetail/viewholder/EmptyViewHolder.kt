package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import android.util.Log
import com.example.riding_balloon.databinding.LayoutItemTravelEmptyBinding
import com.example.riding_balloon.presentation.travelspotdetail.UiModel

class EmptyViewHolder(binding: LayoutItemTravelEmptyBinding) : TravelViewHolder(binding) {
    override fun bind(item: UiModel) {
        Log.d("ViewHolder 체크", "Empty")
    }
}