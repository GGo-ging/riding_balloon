package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder

import android.util.Log
import com.example.riding_balloon.databinding.LayoutItemTravelViewpagerBinding
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter.TravelSpotDetailRecyclerViewAdapter
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter.TravelSpotDetailViewPagerAdapter
import com.example.riding_balloon.presentation.travelspotdetail.UiModel
import com.example.riding_balloon.presentation.travelspotdetail.ViewPagerItemModel

class ViewPagerViewHolderImpl(val binding: LayoutItemTravelViewpagerBinding) : TravelViewHolder(binding) {

    override fun bind(item: UiModel) {

    }

    fun bind(item: UiModel, drawImage: TravelSpotDetailRecyclerViewAdapter.DrawImage?) {
        Log.d("ViewHolder 체크", "ViewPager")
        val vpAdapter = TravelSpotDetailViewPagerAdapter()
        vpAdapter.drawImage = TravelSpotDetailViewPagerAdapter.DrawImage { url ->
            drawImage?.onDraw(url)!!
        }
        binding.vpTravelInfo.adapter = vpAdapter
        val list = (item as UiModel.ViewPagerModel).imageUrlList.map {
            ViewPagerItemModel(
                it
            )
        }
        vpAdapter.submitList(list)
        binding.vpdiTravelInfo.attachTo(binding.vpTravelInfo)
    }
}