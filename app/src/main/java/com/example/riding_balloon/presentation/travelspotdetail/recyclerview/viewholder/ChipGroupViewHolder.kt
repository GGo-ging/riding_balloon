package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder

import com.example.riding_balloon.databinding.LayoutItemTravelChipgroupBinding
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter.TravelSpotDetailRecyclerViewAdapter
import com.example.riding_balloon.presentation.travelspotdetail.UiModel

class ChipGroupViewHolderImpl(private val binding: LayoutItemTravelChipgroupBinding) : TravelViewHolder(binding) {
    override fun bind(item: UiModel) {}

    fun bind(item: UiModel, selectChip: TravelSpotDetailRecyclerViewAdapter.SelectChip?) {
        binding.tvTravelChipgroupTitle.text = "영상으로 ${(item as UiModel.ChipGroupModel).city} 여행하기"
        val chipIdList = listOf(
            binding.chipTravelAll,
            binding.chipTravelTrain,
            binding.chipTravelRestaurant,
            binding.chipTravelBackpacking,
            binding.chipTravelHoneymoon,
            binding.chipTravelHealing,
        )
        val chipTag = listOf(
            "", "기차", "맛집", "배낭", "신혼", "힐링"
        )
        binding.cgTravel.setOnCheckedStateChangeListener { _, ids ->
            val chip = chipIdList.filter { chip -> chip.id == ids.first() }.first()
            selectChip?.onSelect(chipTag[chipIdList.indexOf(chip)])
        }
    }
}