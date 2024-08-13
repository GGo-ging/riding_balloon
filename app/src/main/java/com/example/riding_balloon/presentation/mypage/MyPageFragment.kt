package com.example.riding_balloon.presentation.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.riding_balloon.databinding.FragmentMyPageBinding
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo

class MyPageFragment : Fragment() {

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!
    private val favoriteVideoListAdapter by lazy {
        FavoriteVideoListAdapter { favoriteVideoInfo ->
        }
    }

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
    }

    private fun initView() = with(binding) {
        rvFavoriteVideos.adapter = favoriteVideoListAdapter
        val list = listOf(
            FavoriteVideoInfo(1, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
            FavoriteVideoInfo(2, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
            FavoriteVideoInfo(3, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
            FavoriteVideoInfo(4, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
            FavoriteVideoInfo(5, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
            FavoriteVideoInfo(6, "https://i.ytimg.com/vi/OmeskI1MOVw/sddefault.jpg", "섬이 처음인 우즈벡 형님들의 제주도 적응기 - 어몽&오리뽀(5)", "곽튜브"),
        )
        favoriteVideoListAdapter.submitList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}