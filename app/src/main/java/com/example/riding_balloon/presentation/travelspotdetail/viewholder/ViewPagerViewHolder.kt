package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.LayoutItemTravelViewpagerBinding

class ViewPagerViewHolderImpl(binding: LayoutItemTravelViewpagerBinding) : TravelViewHolder(binding) {
    override fun bind() {
        Log.d("ViewHolder 체크", "ViewPager")
    }
}