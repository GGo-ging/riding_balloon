package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import android.util.Log
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.riding_balloon.databinding.LayoutItemTravelInfoBinding
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListBinding
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotDetailRecyclerViewAdapter
import com.example.riding_balloon.presentation.travelspotdetail.UiModel
import com.google.android.material.chip.Chip

class VideoListViewHolderImpl(val binding: LayoutItemTravelVideoListBinding) : TravelViewHolder(binding) {
    override fun bind(item: UiModel) {
        Log.d("ViewHolder 체크", "VideoList")
    }
}