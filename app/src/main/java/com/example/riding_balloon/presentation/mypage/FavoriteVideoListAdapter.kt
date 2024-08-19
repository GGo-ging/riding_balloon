package com.example.riding_balloon.presentation.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.riding_balloon.databinding.ItemGridVideoBinding
import com.example.riding_balloon.presentation.extensions.load
import com.example.riding_balloon.presentation.extensions.setPublishedDate
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo

class FavoriteVideoListAdapter(
    private val onClick: (FavoriteVideoInfo) -> Unit
) : ListAdapter<FavoriteVideoInfo, FavoriteVideoListAdapter.FavoriteVideoHolder>(
    FavoriteVideoDiffCallback()
) {
    // 선택된 아이템을 저장
    private val selectedItems = mutableSetOf<FavoriteVideoInfo>()

    // 편집 모드 설정 변수
    var isEditMode = false
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteVideoHolder {
        return FavoriteVideoHolder.from(parent, onClick, selectedItems)
    }

    override fun onBindViewHolder(holder: FavoriteVideoHolder, position: Int) {
        holder.bind(getItem(position), isEditMode)
    }

//    // 편집 모드를 설정하는 함수
//    fun setEditMode(editMode: Boolean) {
//        isEditMode = editMode
//        notifyDataSetChanged()
//    }

    // 선택된 아이템들을 가져오는 함수
    fun getSelectedItems(): List<FavoriteVideoInfo> {
        return selectedItems.toList()
    }

    class FavoriteVideoHolder(
        private val binding: ItemGridVideoBinding,
        private val onClick: (FavoriteVideoInfo) -> Unit,
        private val selectedItems: MutableSet<FavoriteVideoInfo>
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(video: FavoriteVideoInfo, isEditMode: Boolean) {
            with(binding) {
                ivGridVideoThumbnail.setOnClickListener {
                    onClick(video)
                }
                ivGridVideoThumbnail.load(video.thumbnailUrl)
                tvGridVideoTitle.text = video.title
                tvGridVideoChannel.text = video.channelTitle
                tvGridVideoPublishDate.setPublishedDate(video.publishedAt)

                // 편집 모드에 따라 뷰의 가시성 조정
                viewGridVideoAlpha.isVisible = isEditMode
                checkboxFavoriteVideo.isVisible = isEditMode

                checkboxFavoriteVideo.isChecked = selectedItems.contains(video)

                // viewGridVideoAlpha 클릭 시 체크박스 상태를 변경
                viewGridVideoAlpha.setOnClickListener {
                    val isChecked = !checkboxFavoriteVideo.isChecked
                    checkboxFavoriteVideo.isChecked = isChecked
                    if (isChecked) {
                        selectedItems.add(video)
                    } else {
                        selectedItems.remove(video)
                    }
                }

                // 체크박스 상태 변경 시 selectedItems에 추가 또는 제거
                checkboxFavoriteVideo.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        selectedItems.add(video)
                    } else {
                        selectedItems.remove(video)
                    }
                }
            }
        }

        companion object {
            fun from(
                parent: ViewGroup,
                onClick: (FavoriteVideoInfo) -> Unit,
                selectedItems: MutableSet<FavoriteVideoInfo>
            ): FavoriteVideoHolder {
                return FavoriteVideoHolder(
                    ItemGridVideoBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onClick, selectedItems
                )
            }
        }
    }
}

private class FavoriteVideoDiffCallback : DiffUtil.ItemCallback<FavoriteVideoInfo>() {
    override fun areItemsTheSame(oldItem: FavoriteVideoInfo, newItem: FavoriteVideoInfo): Boolean {
        return oldItem.videoId == newItem.videoId
    }

    override fun areContentsTheSame(oldItem: FavoriteVideoInfo, newItem: FavoriteVideoInfo): Boolean {
        return oldItem == newItem
    }
}