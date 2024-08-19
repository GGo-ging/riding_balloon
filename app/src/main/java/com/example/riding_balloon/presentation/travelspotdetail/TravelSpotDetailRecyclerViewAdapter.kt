package com.example.riding_balloon.presentation.travelspotdetail

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.RequestBuilder
import com.example.riding_balloon.databinding.LayoutItemTravelChipgroupBinding
import com.example.riding_balloon.databinding.LayoutItemTravelEmptyBinding
import com.example.riding_balloon.databinding.LayoutItemTravelInfoBinding
import com.example.riding_balloon.databinding.LayoutItemTravelVideoListBinding
import com.example.riding_balloon.databinding.LayoutItemTravelViewpagerBinding
import com.example.riding_balloon.presentation.travelspotdetail.diffutil.TravelDiffUtilCallback
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.ChipGroupViewHolderImpl
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.EmptyViewHolder
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.InfoViewHolderImpl
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.TravelViewHolder
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.VideoListViewHolderImpl
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.ViewPagerViewHolderImpl

enum class TSDEnum(val type: Int) {
    VIEW_PAGER(0), INFO(1), CHIP_GROUP(2), VIDEO_LIST(3), EMPTY(-1)
}

class TravelSpotDetailRecyclerViewAdapter : ListAdapter<UiModel, TravelViewHolder>(
    TravelDiffUtilCallback()
) {
    var drawImage: DrawImage? = null
    var drawLayoutManager : DrawLayoutManager? = null
    var selectChip : SelectChip? = null
    var addDecoration: AddDecoration? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        Log.d("ViewHolder 체크", "리스트 : $currentList")
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
                viewHolder = InfoViewHolderImpl(binding)
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
                viewHolder = EmptyViewHolder(binding)
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
                holder.bind(getItem(position), drawImage, drawLayoutManager, addDecoration)
            }
            is ChipGroupViewHolderImpl -> {
                holder.bind(getItem(position), selectChip)
            }
            else -> {
                holder.bind(getItem(position))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is UiModel.ViewPagerModel -> TSDEnum.VIEW_PAGER.type
            is UiModel.InfoModel -> TSDEnum.INFO.type
            is UiModel.TravelVideoListModel -> TSDEnum.VIDEO_LIST.type
            is UiModel.ChipGroupModel -> TSDEnum.CHIP_GROUP.type
        }
    }

    override fun getItemCount(): Int {
        Log.d("ViewHolder 체크", currentList.size.toString())
        return currentList.size
    }

    fun interface DrawImage {
        fun onDraw(url: String): RequestBuilder<Drawable>
    }

    fun interface DrawLayoutManager {
        fun onDraw() : GridLayoutManager
    }

    fun interface SelectChip {
        fun onSelect(chipText: String)
    }

    fun interface AddDecoration {
        fun onAdd() : RecyclerView.ItemDecoration
    }

}

