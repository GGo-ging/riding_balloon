package com.example.riding_balloon.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.databinding.ItemBest10ListBinding

class Best10ListAdapter(): ListAdapter<TravelSpotInfo, Best10ListAdapter.Best10ListHolder>(
    Best10DiffCallback()
) {
    interface ItemClick {
        fun onClickItem(position: Int, item : TravelSpotInfo)
    }
    var itemClick: ItemClick? = null

    class Best10ListHolder(private val binding: ItemBest10ListBinding) : RecyclerView.ViewHolder(binding.root){
        val backgroundImage = binding.ivBackgroundImg
        val ranking = binding.tvRanking
        val country = binding.tvCountry
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Best10ListHolder {
        val binding = ItemBest10ListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Best10ListHolder(binding)
    }

    override fun onBindViewHolder(holder: Best10ListHolder, position: Int) {
        val item = getItem(position)

        with(holder){
            itemView.setOnClickListener {
                itemClick?.onClickItem(position, item)
                notifyItemChanged(position)
            }

            Glide.with(itemView).load(item.thumbnailUrl).into(backgroundImage)
            ranking.text = item.ranking.toString()
            country.text = item.country
        }
    }
}

private class Best10DiffCallback : DiffUtil.ItemCallback<TravelSpotInfo>() {
    override fun areItemsTheSame(oldItem: TravelSpotInfo, newItem: TravelSpotInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TravelSpotInfo, newItem: TravelSpotInfo): Boolean {
        return oldItem == newItem
    }
}