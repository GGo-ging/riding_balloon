package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.LayoutItemTravelViewpagerItemBinding
import com.example.riding_balloon.presentation.travelspotdetail.ViewPagerItemModel

class ViewPagerItemViewHolder(val binding: LayoutItemTravelViewpagerItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ViewPagerItemModel) {
        binding.ivTravelViewpagerItem
    }
}