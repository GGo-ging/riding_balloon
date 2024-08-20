package com.example.riding_balloon.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.riding_balloon.databinding.ItemHomeVideoListBinding
import com.example.riding_balloon.presentation.model.PopularVideoListModel

class PopularVideoListAdapter(): ListAdapter<PopularVideoListModel, PopularVideoListAdapter.PopularYoutubeHolder>(
    PopularYoutubeDiffCallback()
) {
    interface ItemClick {
        fun onClickItem(position: Int, item : PopularVideoListModel)
    }
    var itemClick: ItemClick? = null

    class PopularYoutubeHolder(binding: ItemHomeVideoListBinding) : RecyclerView.ViewHolder(binding.root){
        val image =  binding.ivGridVideoThumbnail
        val title = binding.tvGridVideoTitle
        val channelTitle = binding.tvGridVideoChannel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularYoutubeHolder {
        val binding = ItemHomeVideoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PopularYoutubeHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularYoutubeHolder, position: Int) {
        val item = getItem(position)

        with(holder){
            itemView.setOnClickListener{
                itemClick?.onClickItem(position, item)
            }
            Glide.with(itemView).load(item.thumbnailUrl).into(image)
            title.text = item.title
            channelTitle.text = item.channelTitle
        }
    }

}

private class PopularYoutubeDiffCallback : DiffUtil.ItemCallback<PopularVideoListModel>() {
    override fun areItemsTheSame(oldItem: PopularVideoListModel, newItem: PopularVideoListModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PopularVideoListModel, newItem: PopularVideoListModel): Boolean {
        return oldItem == newItem
    }
}