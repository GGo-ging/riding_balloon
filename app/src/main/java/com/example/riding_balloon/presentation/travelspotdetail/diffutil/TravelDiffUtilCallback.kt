package com.example.riding_balloon.presentation.travelspotdetail.diffutil

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.riding_balloon.presentation.travelspotdetail.UiModel

class TravelDiffUtilCallback : DiffUtil.ItemCallback<UiModel>() {
    override fun areItemsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
        val result = oldItem.id == newItem.id
        Log.d("여행 DiffUtil", "아이디가 같은지 : $result")
        return result
    }

    override fun areContentsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
        val result = oldItem == newItem
        Log.d("여행 DiffUtil", "아이템이 같은지 : $result")
        return result
    }
}