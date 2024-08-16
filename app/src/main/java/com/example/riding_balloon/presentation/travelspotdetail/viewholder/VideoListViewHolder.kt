package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.example.riding_balloon.databinding.LayoutItemTravelInfoBinding
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListBinding

class VideoListViewHolderImpl(binding: LayoutItemTravelVideoListBinding) : TravelViewHolder(binding) {
    override fun bind() {
        Log.d("ViewHolder 체크", "VideoList")
    }
}