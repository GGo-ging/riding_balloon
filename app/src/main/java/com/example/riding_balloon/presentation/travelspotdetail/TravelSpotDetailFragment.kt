package com.example.riding_balloon.presentation.travelspotdetail

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.riding_balloon.PungsunTagoApplication
import com.example.riding_balloon.R
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.data.source.local.room.VideoEntity
import com.example.riding_balloon.data.source.local.room.VideoRoomDB
import com.example.riding_balloon.databinding.FragmentTravelSpotDetailBinding
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@AndroidEntryPoint
class TravelSpotDetailFragment : Fragment() {

    private var _binding: FragmentTravelSpotDetailBinding? = null
    private val binding get() = _binding!!

    private val recyclerViewAdapter = TravelSpotDetailRecyclerViewAdapter()

    private val tsdViewModel by activityViewModels<TravelSpotDetailViewModel>()

    private val viewPagerModel = UiModel.ViewPagerModel(imageUrlList = TravelSpotManager.getListByCountry()[0].images)
    private val infoModel = UiModel.InfoModel(
        nation = TravelSpotManager.getListByCountry()[0].country,
        city = TravelSpotManager.getListByCountry()[0].region,
        desc = TravelSpotManager.getListByCountry()[0].description
    )
    private val videoListModel = UiModel.TravelVideoListModel(videoList = listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerViewAdapter.submitList(
            listOf(
                viewPagerModel,
                infoModel,
                videoListModel.copy(videoList = listOf())
            )
        )
    }

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

        tsdViewModel.videosData.observe(viewLifecycleOwner) {
            recyclerViewAdapter.submitList(
                listOf(
                    viewPagerModel,
                    infoModel,
                    videoListModel.copy(videoList = tsdViewModel.videosData.value ?: listOf())
                )
            )
        }

        binding.rvTravel.adapter = recyclerViewAdapter
        binding.rvTravel.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTravel.addItemDecoration(TsdRecyclerViewSpaceDecoration((resources.displayMetrics.density).roundToInt()))

        recyclerViewAdapter.drawImage = TravelSpotDetailRecyclerViewAdapter.DrawImage { url ->
            Glide.with(this).load(url)
        }

        recyclerViewAdapter.drawLayoutManager = TravelSpotDetailRecyclerViewAdapter.DrawLayoutManager {
            GridLayoutManager(requireContext(),2)
        }

        recyclerViewAdapter.selectChip = TravelSpotDetailRecyclerViewAdapter.SelectChip {
            tsdViewModel.changeData(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun insertVideo(video: List<VideoEntity>) {
        viewLifecycleOwner.lifecycleScope.launch {
            val videoDb = VideoRoomDB.getDatabase((requireActivity().applicationContext as PungsunTagoApplication))
            videoDb.videoDao().insert(video)
        }
    }
}

class TsdRecyclerViewSpaceDecoration(private val px: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val marginBottom = when(position) {
            0 -> px * 16
            1 -> px * 32
            else -> 0
        }
        outRect.bottom = marginBottom
    }
}