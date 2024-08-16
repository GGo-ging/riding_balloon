package com.example.riding_balloon.presentation.mypage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.riding_balloon.databinding.FragmentMyPageBinding
import com.example.riding_balloon.presentation.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : Fragment() {

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!
    private val favoriteVideoListAdapter by lazy {
        FavoriteVideoListAdapter { favoriteVideoInfo ->
        }
    }
    private val favoriteVideoViewModel by activityViewModels<FavoriteVideoViewModel>()
    private val favoriteViewModel by activityViewModels<FavoriteViewModel>()

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
        rvFavoriteVideos.adapter = favoriteVideoListAdapter
    }

    private fun initViewModel() {
//        favoriteVideoViewModel.fetchSearchResult("일본여행")
//        favoriteVideoViewModel.searchResult.observe(viewLifecycleOwner) { searchResult ->
//            searchResult?.let {
//                it.forEach { item ->
//                    Log.d("MyPageFragment", "searchResult: ${item.snippet?.title}")
//                }
//            }
//        }
//        favoriteVideoViewModel.trendingResult.observe(viewLifecycleOwner) { trendingResult ->
//            trendingResult?.let {
//                it.forEach { item ->
//                    Log.d("MyPageFragment", "trendingResult: ${item.snippet?.title}")
//                }
//            }
//        }
//        favoriteVideoViewModel.searchResultOrderByViewCount.observe(viewLifecycleOwner) { searchResultOrderByViewCount ->
//            searchResultOrderByViewCount?.let {
//                it.forEach { item ->
//                    Log.d("MyPageFragment", "searchResultOrderByViewCount: ${item.snippet?.title}")
//                }
//            }
//        }
//        favoriteVideoViewModel.videoDetail.observe(viewLifecycleOwner) { videoDetail ->
//            videoDetail?.let {
//                Log.d("MyPageFragment", "videoDetail: ${videoDetail.title}")
//            }
//        }
//        favoriteVideoViewModel.channelDetail.observe(viewLifecycleOwner) { channelDetail ->
//            channelDetail?.let {
//                Log.d("MyPageFragment", "channelDetail: ${channelDetail.title}")
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}