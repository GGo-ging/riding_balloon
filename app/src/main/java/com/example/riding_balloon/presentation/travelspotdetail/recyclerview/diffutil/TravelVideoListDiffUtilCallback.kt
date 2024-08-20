package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.diffutil

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.riding_balloon.presentation.travelspotdetail.VideoListUiModel

class TravelVideoListDiffUtilCallback : DiffUtil.ItemCallback<VideoListUiModel>() {
    override fun areItemsTheSame(oldItem: VideoListUiModel, newItem: VideoListUiModel): Boolean {
        val result = oldItem.id == newItem.id
        Log.d("비디오 리스트 DiffUtil", "아이디가 같은지 : $result , old id: ${oldItem.id} , new id: ${newItem.id}")
        return result
    }

    override fun areContentsTheSame(oldItem: VideoListUiModel, newItem: VideoListUiModel): Boolean {
        val result = oldItem == newItem
        Log.d("비디오 리스트 DiffUtil", "아이템이 같은지 : $result 뉴${newItem}새 \n , 올${oldItem}새")
        return result
    }

}