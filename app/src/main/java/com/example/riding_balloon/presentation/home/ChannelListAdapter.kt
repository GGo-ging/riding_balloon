package com.example.riding_balloon.presentation.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.ItemGridChannelListBinding
import com.example.riding_balloon.presentation.model.ChannelListModel

class ChannelListAdapter: ListAdapter<ChannelListModel, ChannelListAdapter.Holder>(ChannelDiffCallback()) {
    class Holder(private val binding: ItemGridChannelListBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivChannelImage
        val channelName = binding.tvChannelName
        val subscribers = binding.tvChannelSubscribers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
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