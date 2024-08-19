package com.example.riding_balloon.presentation.travelspotdetail.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.riding_balloon.presentation.travelspotdetail.ViewPagerItemModel

class TravelViewPagerDiffUtilCallback : DiffUtil.ItemCallback<ViewPagerItemModel>() {
    override fun areItemsTheSame(oldItem: ViewPagerItemModel, newItem: ViewPagerItemModel): Boolean {
        return oldItem.imageUrl == newItem.imageUrl
    }

    override fun areContentsTheSame(oldItem: ViewPagerItemModel, newItem: ViewPagerItemModel): Boolean {
        return oldItem == newItem
    }
}