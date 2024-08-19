package com.example.riding_balloon.presentation.travelspotdetail.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.riding_balloon.presentation.travelspotdetail.VideoListUiModel

class TravelVideoListDiffUtilCallback : DiffUtil.ItemCallback<VideoListUiModel>() {
    override fun areItemsTheSame(oldItem: VideoListUiModel, newItem: VideoListUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: VideoListUiModel, newItem: VideoListUiModel): Boolean {
        return oldItem == newItem
    }
}