package com.example.riding_balloon.presentation.travelspotdetail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.riding_balloon.databinding.FragmentTravelSpotDetailBinding

class TravelSpotDetailFragment : Fragment() {

    private var _binding: FragmentTravelSpotDetailBinding? = null
    private val binding get() = _binding!!

    private val recyclerViewAdapter = TravelSpotDetailRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTravelSpotDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewAdapter.submitList(
            listOf(
                UiModel.ViewPagerModel(imageUrlList =  listOf(
                    "https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg",
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTN2TThACkDTMoOIl8Zvb5IdfGOY8laJ5Y6jSZj9AkoYsAnt4aVbuS8wYh-8rfN",
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSMXRkSoKvn34V2gCtolpWuJRoi-0wZkQ_4AuOZFFM9bt8BzsZy42Idd_LhnFOF"
                )),
                UiModel.InfoModel(nation = "", city = "", desc = ""),
                UiModel.TravelVideoListModel()
            )
        )

        binding.rvTravel.adapter = recyclerViewAdapter
        binding.rvTravel.layoutManager = LinearLayoutManager(requireContext())

        recyclerViewAdapter.drawImage = TravelSpotDetailRecyclerViewAdapter.DrawImage { url ->
            Glide.with(this).load(url)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}