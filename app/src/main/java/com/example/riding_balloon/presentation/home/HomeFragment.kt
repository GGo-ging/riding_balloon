package com.example.riding_balloon.presentation.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.riding_balloon.R
import com.example.riding_balloon.databinding.FragmentHomeBinding
import com.example.riding_balloon.presentation.home.adapters.Best10ListAdapter
import com.example.riding_balloon.presentation.home.adapters.ChannelListAdapter
import com.example.riding_balloon.presentation.home.adapters.PopularVideoListAdapter
import com.example.riding_balloon.presentation.model.ChannelListModel
import com.example.riding_balloon.presentation.model.PopularVideoListModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val channelListAdapter by lazy { ChannelListAdapter() }
    private val best10ListAdapter by lazy { Best10ListAdapter() }
    private val popularVideoListAdapter by lazy { PopularVideoListAdapter() }
    private val homeViewModel by viewModels<HomeViewModel>() // fragment의 생명주기를 따르는 viewmodel

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

        rvBest10List.adapter = best10ListAdapter
        channelListAdapter.itemClick = object : ChannelListAdapter.ItemClick {
            override fun onClickItem(position: Int, item: ChannelListModel) {
                val intentYoutube = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/${item.customUrl}"))
                startActivity(intentYoutube)
            }
        }

        rvPopularVideoList.adapter = popularVideoListAdapter
        popularVideoListAdapter.itemClick = object : PopularVideoListAdapter.ItemClick {
            override fun onClickItem(position: Int, item: PopularVideoListModel) {
                val action = HomeFragmentDirections.actionGlobalVideoDetail(item.id)
                requireActivity().findNavController(R.id.container_main).navigate(action)
            }
        }

        with(homeViewModel){
            channelList.observe(viewLifecycleOwner){ itemList -> channelListAdapter.submitList(itemList) }
            best10List.observe(viewLifecycleOwner){ itemList -> best10ListAdapter.submitList(itemList) }
            popularVideoList.observe(viewLifecycleOwner){ itemList -> popularVideoListAdapter.submitList(itemList) }
        }
    }

    private fun initViewModel() = with(homeViewModel){
        fetchChannel()
        getBest10List()
        fetchPopularVideoList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        homeViewModel.clearList()
        homeViewModel.channelList.removeObservers(viewLifecycleOwner)
        homeViewModel.best10List.removeObservers(viewLifecycleOwner)
    }
}