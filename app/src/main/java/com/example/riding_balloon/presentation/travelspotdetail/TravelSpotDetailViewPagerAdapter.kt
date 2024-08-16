package com.example.riding_balloon.presentation.travelspotdetail

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestBuilder
import com.example.riding_balloon.databinding.LayoutItemTravelViewpagerItemBinding
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.ViewPagerItemViewHolder

class TravelSpotDetailViewPagerAdapter :
    ListAdapter<ViewPagerItemModel, ViewPagerItemViewHolder>(
        TravelViewPagerDiffUtilCallback()
    ) {
        var drawImage: DrawImage? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerItemViewHolder {
        val binding = LayoutItemTravelViewpagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewPagerItemViewHolder(binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewPagerItemViewHolder, position: Int) {
        holder.bind(drawImage, getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    fun interface DrawImage {
        fun onDraw(url: String): RequestBuilder<Drawable>
    }

}