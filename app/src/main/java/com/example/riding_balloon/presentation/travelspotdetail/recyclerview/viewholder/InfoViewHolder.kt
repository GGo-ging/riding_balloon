package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.example.riding_balloon.R
import com.example.riding_balloon.databinding.LayoutItemTravelInfoBinding
import com.example.riding_balloon.presentation.travelspotdetail.OnTravelSpotClickListener
import com.example.riding_balloon.presentation.travelspotdetail.UiModel
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter.TravelSpotDetailRecyclerViewAdapter

class InfoViewHolderImpl(
    private val binding: LayoutItemTravelInfoBinding,
    private val onTravelSpotClickListener: OnTravelSpotClickListener<UiModel.InfoModel>
) : TravelViewHolder(binding) {

    override fun bind(item: UiModel) {}

    fun bind(item: UiModel, clickAiButton: TravelSpotDetailRecyclerViewAdapter.ClickAiButton?) {
        Log.d("ViewHolder 체크", "Info")
        item as UiModel.InfoModel
        binding.apply {
            tvTravelCity.text = item.city
            tvTravelNation.text = item.nation
            tvTravelDescription.text = item.desc

            // 초기 isFavorite 상태에 따라 이미지 설정
            ivTravelFavorite.apply {
                isSelected = item.isFavorite
                setOnClickListener {
                    it.isSelected = !it.isSelected

                    // 클릭 이벤트를 전달
                    onTravelSpotClickListener.onTravelSpotClick(item.copy(isFavorite = it.isSelected))
                }
            }
            ivTravelAiBtn.setOnClickListener {
                clickAiButton?.onClick()
            }
        }
    }

    private fun updateFavoriteIcon(isFavorite: Boolean) {
        val iconResId = if (isFavorite) {
            R.drawable.ic_heart // 좋아요 상태 이미지
        } else {
            R.drawable.ic_heart_border // 좋아요 아닌 상태 이미지
        }
        binding.ivTravelFavorite.setImageResource(iconResId)
    }
}