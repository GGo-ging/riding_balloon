package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder

import android.util.Log
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListBinding
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter.TravelSpotDetailRecyclerViewAdapter
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter.TravelSpotDetailVideoListAdapter
import com.example.riding_balloon.presentation.travelspotdetail.UiModel

class VideoListViewHolderImpl(val binding: LayoutItemTravelVideoListBinding) : TravelViewHolder(binding) {
    private val travelSpotDetailVideoListAdapter = TravelSpotDetailVideoListAdapter()
    override fun bind(item: UiModel) {}
    fun bind(
        item: UiModel,
        drawImage: TravelSpotDetailRecyclerViewAdapter.DrawImage?,
        drawLayoutManager: TravelSpotDetailRecyclerViewAdapter.DrawLayoutManager?,
        clickVideo: TravelSpotDetailRecyclerViewAdapter.ClickVideo?,
    ) {
        Log.d("ViewHolder 체크", "VideoList $item")
        travelSpotDetailVideoListAdapter.drawImage = TravelSpotDetailVideoListAdapter.DrawImage { url ->
            drawImage?.onDraw(url)!!
        }
        binding.rvTravelVideoList.adapter = travelSpotDetailVideoListAdapter
        binding.rvTravelVideoList.layoutManager = drawLayoutManager?.onDraw()
        binding.rvTravelVideoList.isNestedScrollingEnabled = false
//        binding.rvTravelVideoList.itemAnimator = null
//        travelSpotDetailVideoListAdapter.list = (item as UiModel.TravelVideoListModel).videoList
//        travelSpotDetailVideoListAdapter.notifyDataSetChanged()
        travelSpotDetailVideoListAdapter.submitList((item as UiModel.TravelVideoListModel).videoList)
        travelSpotDetailVideoListAdapter.clickVideo = TravelSpotDetailVideoListAdapter.ClickVideo { videoId, thumbnailUrl, view ->
            clickVideo?.onClick(videoId, thumbnailUrl, view)
        }

    }
}

