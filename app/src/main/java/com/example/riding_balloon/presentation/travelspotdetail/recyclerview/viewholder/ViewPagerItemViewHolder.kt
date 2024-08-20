package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.LayoutItemTravelViewpagerItemBinding
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter.TravelSpotDetailViewPagerAdapter
import com.example.riding_balloon.presentation.travelspotdetail.ViewPagerItemModel

class ViewPagerItemViewHolder(val binding: LayoutItemTravelViewpagerItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(drawImage: TravelSpotDetailViewPagerAdapter.DrawImage?, item: ViewPagerItemModel) {
        Log.d("ViewHolder 체크", "ViewPagerItem : $item")
        drawImage?.onDraw(item.imageUrl)?.into(binding.ivTravelViewpagerItem)
    }
}