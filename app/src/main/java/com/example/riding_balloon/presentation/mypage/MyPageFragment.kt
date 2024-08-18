package com.example.riding_balloon.presentation.mypage

import android.os.Bundle
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
    }

    private fun initViewModel() {
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