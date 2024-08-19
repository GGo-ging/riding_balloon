package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.RequestBuilder
import com.example.riding_balloon.databinding.LayoutItemTravelInfoBinding
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListBinding
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotDetailRecyclerViewAdapter
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotDetailVideoListAdapter
import com.example.riding_balloon.presentation.travelspotdetail.TsdRecyclerViewSpaceDecoration
import com.example.riding_balloon.presentation.travelspotdetail.UiModel
import com.google.android.material.chip.Chip

class VideoListViewHolderImpl(val binding: LayoutItemTravelVideoListBinding) : TravelViewHolder(binding) {
    override fun bind(item: UiModel) {}
    fun bind(
        item: UiModel,
        drawImage: TravelSpotDetailRecyclerViewAdapter.DrawImage?,
        drawLayoutManager: TravelSpotDetailRecyclerViewAdapter.DrawLayoutManager?,
        selectChip: TravelSpotDetailRecyclerViewAdapter.SelectChip?
    ) {
        Log.d("ViewHolder 체크", "VideoList $item")
        val travelSpotDetailVideoListAdapter = TravelSpotDetailVideoListAdapter()
        travelSpotDetailVideoListAdapter.drawImage = TravelSpotDetailVideoListAdapter.DrawImage { url ->
            drawImage?.onDraw(url)!!
        }
        binding.rvTravelVideoList.adapter = travelSpotDetailVideoListAdapter
        binding.rvTravelVideoList.layoutManager = drawLayoutManager?.onDraw()
//        binding.rvTravelVideoList.addItemDecoration(TsdRecyclerViewSpaceDecoration())
        travelSpotDetailVideoListAdapter.submitList((item as UiModel.TravelVideoListModel).videoList)
        val chipIdList = listOf(
            binding.chipTravelAll,
            binding.chipTravelHealing,
            binding.chipTravelTrain,
            binding.chipTravelRestaurant,
            binding.chipTravelBackpacking,
            binding.chipTravelHoneymoon
        )
        binding.cgTravel.setOnCheckedStateChangeListener { _, ids ->
            val chip = chipIdList.filter { chip -> chip.id == ids.first() }
            selectChip?.onSelect(chip.first().text.toString())
        }
    }
}