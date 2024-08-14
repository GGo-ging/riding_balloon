package com.example.riding_balloon.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.ItemGridChannelListBinding
import com.example.riding_balloon.databinding.ItemGridVideoBinding
import com.example.riding_balloon.presentation.model.ChannelListModel
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo
import com.example.riding_balloon.presentation.mypage.FavoriteVideoListAdapter.FavoriteVideoHolder

class ChannelListAdapter(): ListAdapter<ChannelListModel, ChannelListAdapter.ChannelListHolder>(ChannelDiffCallback()) {
    interface ItemClick {
        fun onClickItem(position: Int, item : ChannelListModel)
    }
    var itemClick: ItemClick? = null

    class ChannelListHolder(private val binding: ItemGridChannelListBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivChannelImage
        val channelName = binding.tvChannelName
        val subscribers = binding.tvChannelSubscribers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelListHolder {
        val binding = ItemGridChannelListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChannelListHolder(binding)
    }

    override fun onBindViewHolder(holder: ChannelListHolder, position: Int) {
        val item = getItem(position)

        with(holder){
            itemView.setOnClickListener {
                itemClick?.onClickItem(position, item)
                notifyItemChanged(position)
            }

            channelName.text = item.name
            subscribers.text = item.subscribers
        }
    }

    companion object {
        fun from(parent: ViewGroup, onClick: (FavoriteVideoInfo) -> Unit): ChannelListHolder {
            return ChannelListHolder(
                ItemGridChannelListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}

private class ChannelDiffCallback : DiffUtil.ItemCallback<ChannelListModel>() {
    override fun areItemsTheSame(oldItem: ChannelListModel, newItem: ChannelListModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChannelListModel, newItem: ChannelListModel): Boolean {
        return oldItem == newItem
    }
}