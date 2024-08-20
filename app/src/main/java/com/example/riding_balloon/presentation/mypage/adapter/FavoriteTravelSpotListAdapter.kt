package com.example.riding_balloon.presentation.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.databinding.ItemBest10ListBinding
import com.example.riding_balloon.presentation.extensions.load

class FavoriteTravelSpotListAdapter(
    private val onClick: (TravelSpotInfo) -> Unit
) : ListAdapter<TravelSpotInfo, FavoriteTravelSpotListAdapter.FavoriteTravelSpotViewHolder>(
    FavoriteTravelSpotDiffCallback()
) {
    // 선택된 아이템을 저장
    private val selectedItems = mutableSetOf<TravelSpotInfo>()

    // 편집 모드 설정 변수
    var isEditMode = false
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTravelSpotViewHolder {
        return FavoriteTravelSpotViewHolder.from(parent, onClick, selectedItems)
    }

    override fun onBindViewHolder(holder: FavoriteTravelSpotViewHolder, position: Int) {
        holder.bind(getItem(position), isEditMode)
    }

//    // 편집 모드를 설정하는 함수
//    fun setEditMode(editMode: Boolean) {
//        isEditMode = editMode
//        notifyDataSetChanged()
//    }

    // 선택된 아이템을 모두 선택하는 함수
    fun selectAllItems(isChecked: Boolean) {
        if (isChecked) {
            selectedItems.addAll(currentList)
        } else {
            selectedItems.clear()
        }
        notifyDataSetChanged()
    }

    // 선택된 아이템들을 가져오는 함수
    fun getSelectedItems(): List<TravelSpotInfo> {
        return selectedItems.toList()
    }

    class FavoriteTravelSpotViewHolder(
        private val binding: ItemBest10ListBinding,
        private val onClick: (TravelSpotInfo) -> Unit,
        private val selectedItems: MutableSet<TravelSpotInfo>
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(travelSpot: TravelSpotInfo, isEditMode: Boolean) {
            with(binding) {
                ivBackgroundImg.setOnClickListener {
                    onClick(travelSpot)
                }
                ivBackgroundImg.load(travelSpot.thumbnailUrl)
                tvCountry.text = travelSpot.region

                // 편집 모드에 따라 뷰의 가시성 조정
//                viewGridVideoAlpha.isVisible = isEditMode
//                checkboxFavoriteVideo.isVisible = isEditMode
//
//                checkboxFavoriteVideo.isChecked = selectedItems.contains(travelSpot)
//
//                // viewGridVideoAlpha 클릭 시 체크박스 상태를 변경
//                viewGridVideoAlpha.setOnClickListener {
//                    val isChecked = !checkboxFavoriteVideo.isChecked
//                    checkboxFavoriteVideo.isChecked = isChecked
//                    if (isChecked) {
//                        selectedItems.add(travelSpot)
//                    } else {
//                        selectedItems.remove(travelSpot)
//                    }
//                }
//
//                // 체크박스 상태 변경 시 selectedItems에 추가 또는 제거
//                checkboxFavoriteVideo.setOnCheckedChangeListener { _, isChecked ->
//                    if (isChecked) {
//                        selectedItems.add(travelSpot)
//                    } else {
//                        selectedItems.remove(travelSpot)
//                    }
//                }
            }
        }

        companion object {
            fun from(
                parent: ViewGroup,
                onClick: (TravelSpotInfo) -> Unit,
                selectedItems: MutableSet<TravelSpotInfo>
            ): FavoriteTravelSpotViewHolder {
                return FavoriteTravelSpotViewHolder(
                    ItemBest10ListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onClick, selectedItems
                )
            }
        }
    }
}

private class FavoriteTravelSpotDiffCallback : DiffUtil.ItemCallback<TravelSpotInfo>() {
    override fun areItemsTheSame(oldItem: TravelSpotInfo, newItem: TravelSpotInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TravelSpotInfo, newItem: TravelSpotInfo): Boolean {
        return oldItem == newItem
    }
}