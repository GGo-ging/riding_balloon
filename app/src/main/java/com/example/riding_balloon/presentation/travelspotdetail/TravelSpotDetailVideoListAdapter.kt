package com.example.riding_balloon.presentation.travelspotdetail

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestBuilder
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListItemBinding
import com.example.riding_balloon.presentation.travelspotdetail.diffutil.TravelVideoListDiffUtilCallback
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.VideoListItemViewHolder

class TravelSpotDetailVideoListAdapter : ListAdapter<VideoListUiModel, RecyclerView.ViewHolder>(
    TravelVideoListDiffUtilCallback()
) {
    var drawImage : DrawImage? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LayoutItemTravelVideoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = VideoListItemViewHolder(binding)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is VideoListItemViewHolder -> holder.bind(uiModel = getItem(position), drawImage = drawImage)
        }
    }

    fun interface DrawImage {
        fun onDraw(url: String): RequestBuilder<Drawable>
    }
}