package com.example.riding_balloon.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.riding_balloon.databinding.ItemGridChannelListBinding
import com.example.riding_balloon.presentation.model.ChannelListModel
import java.text.DecimalFormat

class ChannelListAdapter(): ListAdapter<ChannelListModel, ChannelListAdapter.ChannelListHolder>(
    ChannelDiffCallback()
) {
    interface ItemClick {
        fun onClickItem(position: Int, item : ChannelListModel)
    }
    var itemClick: ItemClick? = null

    class ChannelListHolder(binding: ItemGridChannelListBinding) : RecyclerView.ViewHolder(binding.root) {
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

            Glide.with(itemView).load(item.profileImgUrl).into(image)
            channelName.text = item.name
            subscribers.text = formatNumber(item.subscribers.toLong())
        }
    }

    private fun formatNumber(number: Long): String {
        val formatter = DecimalFormat("#,##0.0")
        if(number < 1000L){
            return formatter.format(number / 10000.0) + "백명"
        } else if(number < 10000L){
            return formatter.format(number / 10000.0) + "천명"
        } else return formatter.format(number / 10000.0) + "만명"
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