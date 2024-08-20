package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListItemBinding
import com.example.riding_balloon.presentation.extensions.setPublishedDate
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotDetailVideoListAdapter
import com.example.riding_balloon.presentation.travelspotdetail.VideoListUiModel

class VideoListItemViewHolder(private val binding : LayoutItemTravelVideoListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(uiModel: VideoListUiModel, drawImage: TravelSpotDetailVideoListAdapter.DrawImage?, clickVideo: TravelSpotDetailVideoListAdapter.ClickVideo?) {
        when(uiModel) {
            is VideoListUiModel.TravelVideoModel -> {
                binding.tvTravelVideoListItemTitle.text = uiModel.videoTitle
                binding.tvTravelVideoListItemChannel.text = uiModel.videoUploader
                binding.tvTravelVideoListItemUploadDate.setPublishedDate(uiModel.videoUploadAt ?: "1900-01-01T00:00:00Z")
                uiModel.videoUrl?.let { drawImage?.onDraw(it)?.into(binding.ivTravelVideoListItem) }
                binding.root.setOnClickListener {
                    clickVideo?.onClick(uiModel.id)
                }
            }
        }
    }
}