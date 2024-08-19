package com.example.riding_balloon.presentation.travelspotdetail.viewholder

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.example.riding_balloon.R
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

            // 초기 isFavorite 상태에 따라 이미지 설정
            updateFavoriteIcon(item.isFavorite)

            // 클릭 이벤트 처리
            ivTravelFavorite.setOnClickListener {
                val newFavoriteState = !item.isFavorite
                // 아이템의 좋아요 상태를 반전시켜 업데이트
                updateFavoriteIcon(newFavoriteState)

                // 클릭 이벤트를 전달
                onTravelSpotClickListener.onTravelSpotClick(item.copy(isFavorite = newFavoriteState))
            }
        }
    }

    // 좋아요 상태에 따라 아이콘을 업데이트하는 함수
    private fun updateFavoriteIcon(isFavorite: Boolean) {
        val iconResId = if (isFavorite) {
            R.drawable.ic_heart // 좋아요 상태 이미지
        } else {
            R.drawable.ic_heart_border // 좋아요 아닌 상태 이미지
        }
        binding.ivTravelFavorite.setImageResource(iconResId)
    }
}