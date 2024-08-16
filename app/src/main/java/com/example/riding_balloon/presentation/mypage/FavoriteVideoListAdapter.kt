package com.example.riding_balloon.presentation.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.riding_balloon.databinding.ItemGridVideoBinding
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo

class FavoriteVideoListAdapter(private val onClick: (FavoriteVideoInfo) -> Unit) : ListAdapter<FavoriteVideoInfo, FavoriteVideoListAdapter.FavoriteVideoHolder>(
    FavoriteVideoDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteVideoHolder {
        val binding = ItemGridVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteVideoHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: FavoriteVideoHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FavoriteVideoHolder(
        private val binding: ItemGridVideoBinding,
        private val onClick: (FavoriteVideoInfo) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(video: FavoriteVideoInfo) {
            itemView.setOnClickListener {
                onClick(video)
            }
            with(binding) {
                Glide.with(ivGridVideoThumbnail)
                    .load(video.thumbnailUrl)
                    .into(ivGridVideoThumbnail)
                tvGridVideoTitle.text = video.title
                tvGridVideoChannel.text = video.channelTitle
            }
        }

        companion object {
            fun from(parent: ViewGroup, onClick: (FavoriteVideoInfo) -> Unit): FavoriteVideoHolder {
                return FavoriteVideoHolder(
                    ItemGridVideoBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onClick
                )
            }
        }
    }
}

private class FavoriteVideoDiffCallback : DiffUtil.ItemCallback<FavoriteVideoInfo>() {
    override fun areItemsTheSame(oldItem: FavoriteVideoInfo, newItem: FavoriteVideoInfo): Boolean {
        return oldItem.videoId == newItem.videoId
    }

    override fun areContentsTheSame(oldItem: FavoriteVideoInfo, newItem: FavoriteVideoInfo): Boolean {
        return oldItem == newItem
    }
}