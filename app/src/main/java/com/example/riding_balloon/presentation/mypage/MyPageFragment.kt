package com.example.riding_balloon.presentation.mypage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.riding_balloon.R
import com.example.riding_balloon.databinding.FragmentMyPageBinding
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo
import com.example.riding_balloon.presentation.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : Fragment() {

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!
    private val favoriteVideoListAdapter by lazy {
        FavoriteVideoListAdapter { favoriteVideo ->
            navigateToVideoDetail(favoriteVideo)
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
//        val list = listOf(
//            FavoriteVideoInfo(1, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
//            FavoriteVideoInfo(2, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
//            FavoriteVideoInfo(3, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
//            FavoriteVideoInfo(4, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
//            FavoriteVideoInfo(5, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
//            FavoriteVideoInfo(6, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
//        )
//        favoriteVideoListAdapter.submitList(list)
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

        favoriteViewModel.favoriteVideos.observe(viewLifecycleOwner) { favoriteVideos ->
            if (favoriteVideos.isNotEmpty()) {
                favoriteVideoListAdapter.submitList(favoriteVideos)
                binding.tvEmptyFavoriteVideos.visibility = View.GONE
            } else {
                binding.tvEmptyFavoriteVideos.visibility = View.VISIBLE
            }
        }
    }

    private fun navigateToVideoDetail(favoriteVideo: FavoriteVideoInfo) {
        val action = MyPageFragmentDirections.actionGlobalVideoDetail(favoriteVideo.videoId)
        requireActivity().findNavController(R.id.container_main).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}