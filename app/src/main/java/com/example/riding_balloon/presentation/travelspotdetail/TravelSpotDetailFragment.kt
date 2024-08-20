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
import androidx.navigation.fragment.navArgs
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
import com.example.riding_balloon.presentation.travelspotdetail.viewholder.LoadingViewHolderImpl
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

var isScrollCoroutineRunning = false

@AndroidEntryPoint
class TravelSpotDetailFragment : Fragment() {

    private var _binding: FragmentTravelSpotDetailBinding? = null
    private val binding get() = _binding!!

//    private val recyclerViewAdapter = TravelSpotDetailRecyclerViewAdapter()
    private val rvAdapter = TravelSpotDetailVideoListAdapter()

    private val tsdViewModel by activityViewModels<TravelSpotDetailViewModel>()

    private val viewPagerModel =
        UiModel.ViewPagerModel(imageUrlList = TravelSpotManager.getListByCountry()[0].images)
    private val infoModel = UiModel.InfoModel(
        nation = TravelSpotManager.getListByCountry()[0].country,
        city = TravelSpotManager.getListByCountry()[0].region,
        desc = TravelSpotManager.getListByCountry()[0].description
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tsdViewModel.initData()
        rvAdapter.submitList(
            listOf()
        )
    }

    private val args: TravelSpotDetailFragmentArgs by navArgs() // 네비게이션으로 전달받은 인자를 사용하기 위한 변수

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

        val chipList = listOf(
            binding.chipTravelAll,
            binding.chipTravelTrain,
            binding.chipTravelRestaurant,
            binding.chipTravelBackpacking,
            binding.chipTravelHoneymoon,
            binding.chipTravelHealing,
        )

        tsdViewModel.videosData.observe(viewLifecycleOwner) {
            rvAdapter.submitList(
                tsdViewModel.videosData.value ?: listOf()
            )
            chipList.forEach {
                it.isEnabled = true
            }
        }

        // args.travelSpot으로 가져오면 됨.
        Log.d("TravelSpotDetailFragment", "args: ${args.travelSpot}")

        setViewPager()
        setInfo()
        setChip()

        binding.rvTravel.apply {
            adapter = rvAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    Log.d("TSD 리사이클러뷰", "$dy 로 변경 중...")
                    if (
                        !binding.rvTravel.canScrollVertically(1) &&
                        tsdViewModel.videosData.value?.isEmpty() == false &&
                        !isScrollCoroutineRunning
                    ) {
                        isScrollCoroutineRunning = true
                        Log.d("TSD 리사이클러뷰", "더 이상 이동 불가!")
//                        tsdViewModel.addData()
                    }
                }
            })
        }

        rvAdapter.drawImage = TravelSpotDetailVideoListAdapter.DrawImage { url ->
            Glide.with(this).load(url)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setChip() {
        binding.tvTravelChipgroupTitle.text = "영상으로 ${infoModel.city} 여행하기"
        val chipTag = listOf(
            "", "기차", "맛집", "배낭", "신혼", "힐링"
        )
        val chipList = listOf(
            binding.chipTravelAll,
            binding.chipTravelTrain,
            binding.chipTravelRestaurant,
            binding.chipTravelBackpacking,
            binding.chipTravelHoneymoon,
            binding.chipTravelHealing,
        )
        binding.cgTravel.setOnCheckedStateChangeListener { _, ids ->
            val chip = chipList.first { chip -> chip.id == ids.first() }
            tsdViewModel.changeData(chipTag[chipList.indexOf(chip)], false)
            chipList.forEach {
                it.isEnabled = false
            }
        }
    }

    private fun setViewPager() {
        val vpAdapter = TravelSpotDetailViewPagerAdapter()
        vpAdapter.drawImage = TravelSpotDetailViewPagerAdapter.DrawImage { url ->
            Glide.with(this).load(url)
        }
        binding.vpTravelInfo.adapter = vpAdapter
        val list = viewPagerModel.imageUrlList.map {
            ViewPagerItemModel(
                it
            )
        }
        vpAdapter.submitList(list)
        binding.vpdiTravelInfo.attachTo(binding.vpTravelInfo)
    }

    private fun setInfo() {
        binding.apply {
            tvTravelCity.text = infoModel.city
            tvTravelNation.text = infoModel.nation
            tvTravelDescription.text = infoModel.desc
        }
    }
}

//    private val chipGroupModel = UiModel.ChipGroupModel(
//        city = TravelSpotManager.getListByCountry()[0].region
//    )
//    private val videoListModel = UiModel.TravelVideoListModel(videoList = listOf())
//    private val loadingModel = UiModel.VideoListLoadingUiModel()

//        recyclerViewAdapter.submitList(
//            listOf(
//                viewPagerModel,
//                infoModel,
//                chipGroupModel,
//                loadingModel
//            )
//        )

//            recyclerViewAdapter.submitList(
//                listOf(
//                    viewPagerModel,
//                    infoModel,
//                    chipGroupModel,
//                    videoListModel.copy(
//                        id = videoListModel.id,
//                        videoList = tsdViewModel.videosData.value ?: listOf()
//                    )
//                )
//            )

//            adapter = recyclerViewAdapter
//            layoutManager = LinearLayoutManager(requireContext())

//            addItemDecoration(TsdRecyclerViewSpaceDecoration(resources.displayMetrics.density.roundToInt()))
//            isNestedScrollingEnabled = false

//                        recyclerViewAdapter.submitList(
//                            listOf(
//                                viewPagerModel,
//                                infoModel,
//                                chipGroupModel,
//                                videoListModel.copy(
//                                    id = videoListModel.id,
//                                    videoList = tsdViewModel.videosData.value ?: listOf()
//                                ),
//                                UiModel.VideoListLoadingUiModel()
//                            )
//                        )

//        recyclerViewAdapter.drawImage = TravelSpotDetailRecyclerViewAdapter.DrawImage { url ->
//            Glide.with(this).load(url)
//        }

//
//        recyclerViewAdapter.drawLayoutManager =
//            TravelSpotDetailRecyclerViewAdapter.DrawLayoutManager {
//                GridLayoutManager(requireContext(), 2)
//            }
//
//        recyclerViewAdapter.selectChip = TravelSpotDetailRecyclerViewAdapter.SelectChip {
//            tsdViewModel.changeData(it, false)
//        }

//    private fun insertVideo(video: List<VideoEntity>) {
//        viewLifecycleOwner.lifecycleScope.launch {
//            val videoDb =
//                VideoRoomDB.getDatabase((requireActivity().applicationContext as PungsunTagoApplication))
//            videoDb.videoDao().insert(video)
//        }
//    }

//class TsdRecyclerViewSpaceDecoration(private val px: Int) : RecyclerView.ItemDecoration() {
//    override fun getItemOffsets(
//        outRect: Rect,
//        view: View,
//        parent: RecyclerView,
//        state: RecyclerView.State
//    ) {
//        val position = parent.getChildAdapterPosition(view)
//        val marginBottom = when (position) {
//            0 -> px * 16
//            1 -> px * 32
//            2 -> px * 16
//            else -> 0
//        }
//        outRect.bottom = marginBottom
//    }
//}