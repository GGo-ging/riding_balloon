package com.example.riding_balloon.presentation.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.databinding.ItemBest10ListBinding
import com.example.riding_balloon.databinding.ItemFavoriteTravelSpotBinding
import com.example.riding_balloon.databinding.ItemFavoriteTravelSpotEditBinding
import com.example.riding_balloon.presentation.extensions.load

enum class FavoriteTravelSpotViewType {
    LINEAR, GRID
}

class FavoriteTravelSpotListAdapter(
    private val onClick: (TravelSpotInfo) -> Unit
) : ListAdapter<TravelSpotInfo, RecyclerView.ViewHolder>(
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

    override fun getItemViewType(position: Int): Int {
        return if (isEditMode) {
            FavoriteTravelSpotViewType.GRID.ordinal
        } else {
            FavoriteTravelSpotViewType.LINEAR.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FavoriteTravelSpotViewType.LINEAR.ordinal -> FavoriteTravelSpotViewHolder.from(parent, onClick, selectedItems)
            FavoriteTravelSpotViewType.GRID.ordinal -> FavoriteTravelSpotEditViewHolder.from(parent, onClick, selectedItems)
            else -> throw IllegalArgumentException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val travelSpot = getItem(position)
        when (holder) {
            is FavoriteTravelSpotViewHolder -> holder.bind(travelSpot, isEditMode)
            is FavoriteTravelSpotEditViewHolder -> holder.bind(travelSpot, isEditMode)
        }
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
        private val binding: ItemFavoriteTravelSpotBinding,
        private val onClick: (TravelSpotInfo) -> Unit,
        private val selectedItems: MutableSet<TravelSpotInfo>
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(travelSpot: TravelSpotInfo, isEditMode: Boolean) {
            with(binding) {
                ivFavoriteTravelSpotThumbnail.setOnClickListener {
                    onClick(travelSpot)
                }
                ivFavoriteTravelSpotThumbnail.load(travelSpot.thumbnailUrl)
                tvFavoriteTravelSpotCountry.text = travelSpot.country
                tvFavoriteTravelSpotRegion.text = travelSpot.region

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
                    ItemFavoriteTravelSpotBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onClick, selectedItems
                )
            }
        }
    }

    class FavoriteTravelSpotEditViewHolder(
        private val binding: ItemFavoriteTravelSpotEditBinding,
        private val onClick: (TravelSpotInfo) -> Unit,
        private val selectedItems: MutableSet<TravelSpotInfo>
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(travelSpot: TravelSpotInfo, isEditMode: Boolean) {
            with(binding) {
                ivFavoriteTravelSpotEditThumbnail.setOnClickListener {
                    onClick(travelSpot)
                }
                ivFavoriteTravelSpotEditThumbnail.load(travelSpot.thumbnailUrl)
                tvFavoriteTravelSpotEditCountry.text = travelSpot.country
                tvFavoriteTravelSpotEditRegion.text = travelSpot.region

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
            ): FavoriteTravelSpotEditViewHolder {
                return FavoriteTravelSpotEditViewHolder(
                    ItemFavoriteTravelSpotEditBinding.inflate(
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