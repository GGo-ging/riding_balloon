package com.example.riding_balloon.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.riding_balloon.databinding.FragmentHomeBinding
import com.example.riding_balloon.presentation.mypage.FavoriteVideoListAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val channelListAdapter by lazy { ChannelListAdapter() }
    private val homeViewModel by activityViewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
    }

    private fun initView() = with(binding){
        rvChannelList.adapter = channelListAdapter
        rvChannelList.layoutManager = GridLayoutManager(context, 3)

        homeViewModel.channelList.observe(viewLifecycleOwner){ itemList ->
            channelListAdapter.submitList(itemList.toMutableList())
        }
    }

    private fun initViewModel(){
        homeViewModel.fetchChannel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}