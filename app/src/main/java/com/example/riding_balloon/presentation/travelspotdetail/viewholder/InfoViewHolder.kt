package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.example.riding_balloon.databinding.LayoutItemTravelInfoBinding
import com.example.riding_balloon.presentation.travelspotdetail.OnTravelSpotClickListener
import com.example.riding_balloon.presentation.travelspotdetail.UiModel

class InfoViewHolderImpl(
    private val binding: LayoutItemTravelInfoBinding,
    private val onTravelSpotClickListener: OnTravelSpotClickListener<UiModel.InfoModel>
) : TravelViewHolder(binding) {

    override fun bind(item: UiModel) {
        Log.d("ViewHolder 체크", "Info")
        item as UiModel.InfoModel

        binding.apply {
            tvTravelCity.text = item.city
            tvTravelNation.text = item.nation
            tvTravelDescription.text = item.desc

            ivTravelFavorite.setOnClickListener {
                onTravelSpotClickListener.onTravelSpotClick(item)
            }
        }
    }
}