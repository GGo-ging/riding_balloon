package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder

import android.util.Log
import com.example.riding_balloon.databinding.LayoutItemTravelEmptyBinding
import com.example.riding_balloon.presentation.travelspotdetail.UiModel

class EmptyViewHolderImpl(binding: LayoutItemTravelEmptyBinding) : TravelViewHolder(binding) {
    override fun bind(item: UiModel) {
        Log.d("ViewHolder 체크", "Empty")
    }
}