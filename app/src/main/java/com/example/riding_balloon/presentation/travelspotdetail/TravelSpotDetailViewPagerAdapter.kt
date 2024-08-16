package com.example.riding_balloon.presentation.travelspotdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.LayoutItemTravelViewpagerItemBinding
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.ViewPagerItemViewHolder

class TravelSpotDetailViewPagerAdapterImpl :
    ListAdapter<ViewPagerItemModel, ViewPagerItemViewHolder>(
        TravelViewPagerDiffUtilCallback()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerItemViewHolder {
        val binding = LayoutItemTravelViewpagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewPagerItemViewHolder(binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewPagerItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

}