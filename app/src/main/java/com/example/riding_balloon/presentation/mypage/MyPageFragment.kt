package com.example.riding_balloon.presentation.mypage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.riding_balloon.R
import com.example.riding_balloon.databinding.FragmentMyPageBinding
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo
import com.example.riding_balloon.presentation.mypage.adapter.FavoriteTravelSpotListAdapter
import com.example.riding_balloon.presentation.mypage.adapter.FavoriteVideoListAdapter
import com.example.riding_balloon.presentation.viewmodel.FavoriteTravelSpotViewModel
import com.example.riding_balloon.presentation.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : Fragment() {

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!
    private val favoriteTravelSpotListAdapter by lazy {
        FavoriteTravelSpotListAdapter { travelSpot ->
            //navigateToTravelSpotDetail(travelSpot)
            Toast.makeText(requireContext(), "${travelSpot.country}", Toast.LENGTH_SHORT).show()
        }
    }
    private val favoriteVideoListAdapter by lazy {
        FavoriteVideoListAdapter { view, favoriteVideo ->
            navigateToVideoDetail(view, favoriteVideo)
        }
    }
    private val favoriteVideoViewModel by activityViewModels<FavoriteVideoViewModel>()
    private val favoriteViewModel by activityViewModels<FavoriteViewModel>()
    private val favoriteTravelSpotViewModel by activityViewModels<FavoriteTravelSpotViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
    }

    private fun initView() = with(binding) {
        rvFavoriteTravelSpots.adapter = favoriteTravelSpotListAdapter
        rvFavoriteVideos.adapter = favoriteVideoListAdapter

        tvLabelFavoriteTravelSpotsEdit.setOnClickListener {
            // isEditMode를 직접 토글
            favoriteTravelSpotListAdapter.isEditMode = !favoriteTravelSpotListAdapter.isEditMode

            if (favoriteTravelSpotListAdapter.isEditMode) {
                rvFavoriteTravelSpots.layoutManager = GridLayoutManager(requireContext(), 3)
                checkboxSelectAllFavoriteTravelSpots.visibility = View.VISIBLE
                tvLabelFavoriteTravelSpotsDelete.visibility = View.VISIBLE
                tvLabelMyFavoriteTravelSpots.setText(R.string.label_select_all)
                tvLabelFavoriteTravelSpotsEdit.setText(R.string.label_edit_complete)
            } else {
                rvFavoriteTravelSpots.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                checkboxSelectAllFavoriteTravelSpots.visibility = View.GONE
                tvLabelFavoriteTravelSpotsDelete.visibility = View.GONE
                tvLabelMyFavoriteTravelSpots.setText(R.string.label_my_favorite_videos)
                tvLabelFavoriteTravelSpotsEdit.setText(R.string.label_edit)
            }
        }

        tvLabelFavoriteTravelSpotsDelete.setOnClickListener {
            val selectedItems = favoriteTravelSpotListAdapter.getSelectedItems()
            if (selectedItems.isNotEmpty()) {
                favoriteTravelSpotViewModel.removeMultipleFavoriteItems(selectedItems)
                Toast.makeText(requireContext(), "선택된 아이템이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                favoriteTravelSpotListAdapter.clearSelectedItems()
            } else {
                Toast.makeText(requireContext(), "선택된 아이템이 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        checkboxSelectAllFavoriteTravelSpots.setOnCheckedChangeListener { _, isChecked ->
            favoriteTravelSpotListAdapter.selectAllItems(isChecked)
        }

        tvLabelFavoriteVideosEdit.setOnClickListener {
            // isEditMode를 직접 토글
            favoriteVideoListAdapter.isEditMode = !favoriteVideoListAdapter.isEditMode

            if (favoriteVideoListAdapter.isEditMode) {
                checkboxSelectAllFavoriteVideos.visibility = View.VISIBLE
                tvLabelFavoriteVideosDelete.visibility = View.VISIBLE
                tvLabelMyFavoriteVideos.setText(R.string.label_select_all)
                tvLabelFavoriteVideosEdit.setText(R.string.label_edit_complete)
            } else {
                checkboxSelectAllFavoriteVideos.visibility = View.GONE
                tvLabelFavoriteVideosDelete.visibility = View.GONE
                tvLabelMyFavoriteVideos.setText(R.string.label_my_favorite_videos)
                tvLabelFavoriteVideosEdit.setText(R.string.label_edit)
            }
        }

        tvLabelFavoriteVideosDelete.setOnClickListener {
            val selectedItems = favoriteVideoListAdapter.getSelectedItems()
            if (selectedItems.isNotEmpty()) {
                favoriteViewModel.removeMultipleFavoriteItems(selectedItems)
                Toast.makeText(requireContext(), "선택된 아이템이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                favoriteVideoListAdapter.clearSelectedItems()
            } else {
                Toast.makeText(requireContext(), "선택된 아이템이 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        checkboxSelectAllFavoriteVideos.setOnCheckedChangeListener { _, isChecked ->
            favoriteVideoListAdapter.selectAllItems(isChecked)
        }
    }

    private fun initViewModel() {
        favoriteTravelSpotViewModel.favoriteTravelSpots.observe(viewLifecycleOwner) { favoriteTravelSpots ->
            if (favoriteTravelSpots.isNotEmpty()) {
                favoriteTravelSpotListAdapter.submitList(favoriteTravelSpots)
                binding.tvEmptyFavoriteTravelSpots.visibility = View.INVISIBLE
            } else {
                favoriteTravelSpotListAdapter.submitList(mutableListOf())
                binding.tvEmptyFavoriteTravelSpots.visibility = View.VISIBLE
            }
        }

        favoriteViewModel.favoriteVideos.observe(viewLifecycleOwner) { favoriteVideos ->
            if (favoriteVideos.isNotEmpty()) {
                favoriteVideoListAdapter.submitList(favoriteVideos)
                binding.tvEmptyFavoriteVideos.visibility = View.INVISIBLE
            } else {
                favoriteVideoListAdapter.submitList(mutableListOf())
                binding.tvEmptyFavoriteVideos.visibility = View.VISIBLE
            }
        }
    }

    private fun navigateToVideoDetail(view: View, favoriteVideo: FavoriteVideoInfo) {
        val action = MyPageFragmentDirections.actionGlobalVideoDetail(favoriteVideo.videoId, favoriteVideo.thumbnailUrl)

        // transitionName을 가진 뷰를 FragmentNavigatorExtras에 전달
        val extras = FragmentNavigatorExtras(
            view to "thumbnail_${favoriteVideo.videoId}"
        )
        findNavController().navigate(action, extras)
    }

    override fun onStop() {
        super.onStop()
        favoriteTravelSpotListAdapter.isEditMode = false // 상세 페이지 이동 시 편집 모드 해제
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}