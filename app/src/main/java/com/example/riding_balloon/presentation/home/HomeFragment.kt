package com.example.riding_balloon.presentation.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.databinding.FragmentHomeBinding
import com.example.riding_balloon.presentation.home.adapters.Best10ListAdapter
import com.example.riding_balloon.presentation.home.adapters.ChannelListAdapter
import com.example.riding_balloon.presentation.model.ChannelListModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val channelListAdapter by lazy { ChannelListAdapter() }
    private val best10ListAdapter by lazy { Best10ListAdapter() }
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

        rvBest10List.adapter = best10ListAdapter
        channelListAdapter.itemClick = object : ChannelListAdapter.ItemClick {
            override fun onClickItem(position: Int, item: ChannelListModel) {
                val intentYoutube = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/${item.customUrl}"))
                startActivity(intentYoutube)
            }
        }

            with(homeViewModel){
            channelList.observe(viewLifecycleOwner){ itemList -> channelListAdapter.submitList(itemList) }
            best10List.observe(viewLifecycleOwner){ itemList -> best10ListAdapter.submitList(itemList) }
        }
    }

    private fun initViewModel() = with(homeViewModel){
        fetchChannel()
        getBest10List()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}