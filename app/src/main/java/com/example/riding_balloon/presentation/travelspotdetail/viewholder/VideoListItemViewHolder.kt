package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListItemBinding
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotDetailVideoListAdapter
import com.example.riding_balloon.presentation.travelspotdetail.VideoListUiModel

class VideoListItemViewHolder(private val binding : LayoutItemTravelVideoListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(uiModel: VideoListUiModel, drawImage: TravelSpotDetailVideoListAdapter.DrawImage?) {
        when(uiModel) {
            is VideoListUiModel.TravelVideoModel -> {
                binding.tvTravelVideoListItemTitle.text = uiModel.videoTitle
                binding.tvTravelVideoListItemChannel.text = uiModel.videoUploader
                binding.tvTravelVideoListItemViewCount.text = "조회수 3333만회" //uiModel.videoViewCount
                uiModel.videoUrl?.let { drawImage?.onDraw(it)?.into(binding.ivTravelVideoListItem) }
            }
        }
    }
}