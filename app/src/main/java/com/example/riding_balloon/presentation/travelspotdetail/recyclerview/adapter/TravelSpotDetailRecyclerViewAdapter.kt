package com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.RequestBuilder
import com.example.riding_balloon.databinding.LayoutItemTravelChipgroupBinding
import com.example.riding_balloon.databinding.LayoutItemTravelEmptyBinding
import com.example.riding_balloon.databinding.LayoutItemTravelInfoBinding
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListBinding
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListLoadingBinding
import com.example.riding_balloon.databinding.LayoutItemTravelViewpagerBinding
import com.example.riding_balloon.presentation.travelspotdetail.OnTravelSpotClickListener
import com.example.riding_balloon.presentation.travelspotdetail.UiModel
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.diffutil.TravelDiffUtilCallback
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder.ChipGroupViewHolderImpl
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder.EmptyViewHolderImpl
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder.InfoViewHolderImpl
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder.LoadingViewHolderImpl
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder.TravelViewHolder
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder.VideoListViewHolderImpl
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.viewholder.ViewPagerViewHolderImpl

enum class TSDEnum(val type: Int) {
    VIEW_PAGER(0), INFO(1), CHIP_GROUP(2), VIDEO_LIST(3), LOADING(4), EMPTY(-1)
}

class TravelSpotDetailRecyclerViewAdapter<T: UiModel>(
    private val onTravelSpotClickListener: OnTravelSpotClickListener<T>
) : ListAdapter<UiModel, TravelViewHolder>(
    TravelDiffUtilCallback()
) {
    var drawImage: DrawImage? = null
    var drawLayoutManager : DrawLayoutManager? = null
    var selectChip : SelectChip? = null
    var clickVideo: ClickVideo? = null
    var clickAiButton: ClickAiButton? = null
    var list: List<UiModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        Log.d("ViewHolder 체크", "리스트 : $list")
        val holderType = TSDEnum.entries.find {
            it.type == viewType
        } ?: TSDEnum.EMPTY
        val binding : ViewBinding
        lateinit var viewHolder: TravelViewHolder
        when(holderType) {
            TSDEnum.VIEW_PAGER -> {
                binding = LayoutItemTravelViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                viewHolder = ViewPagerViewHolderImpl(binding)
            }
            TSDEnum.INFO -> {
                binding = LayoutItemTravelInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                viewHolder = InfoViewHolderImpl(binding, onTravelSpotClickListener as OnTravelSpotClickListener<UiModel.InfoModel>)
            }
            TSDEnum.CHIP_GROUP -> {
                binding = LayoutItemTravelChipgroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                viewHolder = ChipGroupViewHolderImpl(binding)
            }
            TSDEnum.VIDEO_LIST -> {
                binding = LayoutItemTravelVideoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                viewHolder = VideoListViewHolderImpl(binding)
            }
            TSDEnum.EMPTY -> {
                binding = LayoutItemTravelEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                viewHolder = EmptyViewHolderImpl(binding)
            }
            TSDEnum.LOADING -> {
                binding = LayoutItemTravelVideoListLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                viewHolder = LoadingViewHolderImpl(binding)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        Log.d("ViewHolder 체크", "Bind")
        when(holder) {
            is ViewPagerViewHolderImpl -> {
                holder.bind(getItem(position), drawImage)
            }
            is VideoListViewHolderImpl -> {
                holder.bind(getItem(position), drawImage, drawLayoutManager, clickVideo)
            }
            is ChipGroupViewHolderImpl -> {
                holder.bind(getItem(position), selectChip)
            }
            is InfoViewHolderImpl -> {
                holder.bind(getItem(position), clickAiButton)
            }
            else -> {
                holder.bind(getItem(position))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(currentList[position]) {
            is UiModel.ViewPagerModel -> TSDEnum.VIEW_PAGER.type
            is UiModel.InfoModel -> TSDEnum.INFO.type
            is UiModel.TravelVideoListModel -> TSDEnum.VIDEO_LIST.type
            is UiModel.ChipGroupModel -> TSDEnum.CHIP_GROUP.type
            is UiModel.VideoListLoadingUiModel -> TSDEnum.LOADING.type
        }
    }
//
//    override fun getItem(position: Int): UiModel {
//        return list[position]
//    }
//
//    override fun getItemCount(): Int = list.size
//
//    override fun getItemId(position: Int) = position.toLong()

    fun interface DrawImage {
        fun onDraw(url: String): RequestBuilder<Drawable>
    }

    fun interface DrawLayoutManager {
        fun onDraw() : LinearLayoutManager
    }

    fun interface SelectChip {
        fun onSelect(chipText: String)
    }

    fun interface ClickVideo {
        fun onClick(videoId: String, thumbnailUrl: String, view: View)
    }

    fun interface ClickAiButton {
        fun onClick()
    }

}

