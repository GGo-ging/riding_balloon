package com.example.riding_balloon.presentation.travelspotdetail

import androidx.recyclerview.widget.DiffUtil

class TravelViewPagerDiffUtilCallback : DiffUtil.ItemCallback<ViewPagerItemModel>() {
    override fun areItemsTheSame(oldItem: ViewPagerItemModel, newItem: ViewPagerItemModel): Boolean {
        return oldItem.imageUrl == newItem.imageUrl
    }

    override fun areContentsTheSame(oldItem: ViewPagerItemModel, newItem: ViewPagerItemModel): Boolean {
        return oldItem == newItem
    }
}