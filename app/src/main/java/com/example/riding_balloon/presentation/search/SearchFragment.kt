package com.example.riding_balloon.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.riding_balloon.R
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
//        binding.recyclerView.adapter = SearchFragmentAdapter(TravelSpotManager.travelSpotList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}