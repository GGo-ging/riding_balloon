package com.example.riding_balloon.presentation.travelspotdetail

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.riding_balloon.R
import com.example.riding_balloon.databinding.FragmentTravelSpotDetailBinding
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo
import com.example.riding_balloon.presentation.mypage.MyPageFragmentDirections
import com.example.riding_balloon.presentation.travelspotdetail.recyclerview.adapter.TravelSpotDetailRecyclerViewAdapter
import com.example.riding_balloon.presentation.viewmodel.FavoriteTravelSpotViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

var isScrollCoroutineRunning = false

@AndroidEntryPoint
class TravelSpotDetailFragment : Fragment(), OnTravelSpotClickListener<UiModel> {

    private var _binding: FragmentTravelSpotDetailBinding? = null
    private val binding get() = _binding!!

    private val recyclerViewAdapter = TravelSpotDetailRecyclerViewAdapter(this)

    private val tsdViewModel by activityViewModels<TravelSpotDetailViewModel>()
    private val aiViewModel by activityViewModels<AiBottomSheetViewModel>()

    private val args: TravelSpotDetailFragmentArgs by navArgs() // 네비게이션으로 전달받은 인자를 사용하기 위한 변수
    private val favoriteTravelSpotViewModel by activityViewModels<FavoriteTravelSpotViewModel>()

    private lateinit var viewPagerModel : UiModel.ViewPagerModel
    private lateinit var infoModel : UiModel.InfoModel
    private lateinit var chipGroupModel : UiModel.ChipGroupModel
    // 얘가 계속해서 copy 하니까 문제가 리스트가 초기화되는 문제가 생기는 게 아닐까? -> var 로 바꾸고 그대로 가도록 해보기 -> 깜빡이는 건 사라졌지만 그대로임 -> 안쪽도 바꿔보기?
    // -> 외부 리사이클러뷰의 arecontentsame가 data class 안의 list를 확인하고 다름을 인식해서 자꾸 맨 위로 초기화되는 것 -> 그러면 list를 따로 전달?
    // -> 혹은 getPayload?나 arethecontentsame 을 다르게 해서 처리할 수 있을 듯. ai 끝나고 시도 한번 해보고 안 될 거 같으면 애니메이션이나 넣기
    private var videoListModel = UiModel.TravelVideoListModel(videoList = listOf())
    private val loadingModel = UiModel.VideoListLoadingUiModel()

    private val gptLoadingFragment = GptLoadingFragment()

    private lateinit var travelSpotInfoUiModel : TravelSpotInfoUiModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Args 확인 OnCreate", "${args.travelSpot.id}")
        tsdViewModel.setTravelSpot(args.travelSpot.id)
        tsdViewModel.initData()
        travelSpotInfoUiModel = tsdViewModel.getTravelSpot()
        viewPagerModel = UiModel.ViewPagerModel(
            imageUrlList = travelSpotInfoUiModel.images
        )
        infoModel = UiModel.InfoModel(
            nation = travelSpotInfoUiModel.country,
            city = travelSpotInfoUiModel.region,
            desc = travelSpotInfoUiModel.description,
            isFavorite = favoriteTravelSpotViewModel.isFavorite(args.travelSpot.id)
        )
        chipGroupModel = UiModel.ChipGroupModel(
            city = travelSpotInfoUiModel.region
        )
        recyclerViewAdapter.submitList(
//        recyclerViewAdapter.list =
            listOf(
                viewPagerModel,
                infoModel,
                chipGroupModel,
//                videoListModel,
                loadingModel
            )
//        recyclerViewAdapter.notifyDataSetChanged()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("Args 확인 OnCreateView", "${args.travelSpot.id}")
        _binding = FragmentTravelSpotDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tsdViewModel.videosData.observe(viewLifecycleOwner) {
            videoListModel = videoListModel.copy(
                id = videoListModel.id,
                videoList = tsdViewModel.videosData.value?.filterIsInstance<VideoListUiModel.TravelVideoModel>()?.map {
                    VideoListUiModel.TravelVideoModel(
                        id = it.id,
                        videoTitle = it.videoTitle,
                        videoUrl = it.videoUrl,
                        videoUploader = it.videoUploader,
                        videoUploadAt = it.videoUploadAt,
                    )
                } ?: listOf()
            )
            recyclerViewAdapter.submitList(
                listOf(
                    viewPagerModel,
                    infoModel,
                    chipGroupModel,
                    videoListModel,
//                    loadingModel
                )
            )
//            recyclerViewAdapter.list =
//                listOf(
//                    viewPagerModel,
//                    infoModel,
//                    chipGroupModel,
//                    videoListModel.copy(
//                        id = videoListModel.id,
//                        videoList = tsdViewModel.videosData.value ?: listOf()
//                    )
//                )
//            recyclerViewAdapter.notifyDataSetChanged()
        }

        // args.travelSpot으로 가져오면 됨.
        Log.d("TravelSpotDetailFragment", "args: ${args.travelSpot}")

        binding.rvTravel.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(TsdRecyclerViewSpaceDecoration(resources.displayMetrics.density.roundToInt()))
            isNestedScrollingEnabled = false
//            itemAnimator = null

            // 무한 스크롤
//            addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//                    Log.d("TSD 리사이클러뷰", "$dy 로 변경 중...")
//                    if (
//                        !binding.rvTravel.canScrollVertically(1) &&
//                        tsdViewModel.videosData.value?.isEmpty() == false &&
//                        !isScrollCoroutineRunning
//                    ) {
//                        isScrollCoroutineRunning = true
//                        Log.d("TSD 리사이클러뷰", "더 이상 이동 불가!")
//                        recyclerViewAdapter.submitList(
////                        recyclerViewAdapter.list =
//                            listOf(
//                                viewPagerModel,
//                                infoModel,
//                                chipGroupModel,
//                                videoListModel,
//                                loadingModel
//                            )
//                        )
////                        recyclerViewAdapter.notifyDataSetChanged()
//                        tsdViewModel.addData()
//                    }
//                }
//            })
        }

        binding.toolbarTravelBack.ivToolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }

        recyclerViewAdapter.drawImage = TravelSpotDetailRecyclerViewAdapter.DrawImage { url ->
            Glide.with(this).load(url)
        }
        recyclerViewAdapter.drawLayoutManager =
            TravelSpotDetailRecyclerViewAdapter.DrawLayoutManager {
                GridLayoutManager(requireContext(), 2)
            }

        recyclerViewAdapter.selectChip = TravelSpotDetailRecyclerViewAdapter.SelectChip {
            tsdViewModel.changeData(it, false)
        }

        recyclerViewAdapter.clickVideo = TravelSpotDetailRecyclerViewAdapter.ClickVideo { videoId, thumbnailUrl, view ->
            sendItemFromTsdToVideo(videoId, thumbnailUrl, view)
        }

        recyclerViewAdapter.clickAiButton = TravelSpotDetailRecyclerViewAdapter.ClickAiButton {
            requireActivity().supportFragmentManager.commit {
                add(R.id.container_main, gptLoadingFragment)
            }
            aiViewModel.getAiMessage(tsdViewModel.getTravelSpotName())
        }

        aiViewModel.aiMessage.observe(viewLifecycleOwner) {
//            modalWithRoundCorner()
            requireActivity().supportFragmentManager.commit {
                remove(gptLoadingFragment)
            }
            TsdAiDialogFragment().show(requireActivity().supportFragmentManager, "ai dialog")
        }

    }

    private fun modalWithRoundCorner() {
        val bottomSheetFragment = TsdAiBottomSheetFragment()
        bottomSheetFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundCornerBottomSheetDialog)
        bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun sendItemFromTsdToVideo(videoId: String, thumbnailUrl: String, view: View) {
        val action = TravelSpotDetailFragmentDirections.actionGlobalVideoDetail(videoId = videoId, thumbnailUrl = thumbnailUrl)
        val extras = FragmentNavigatorExtras(
            view to "thumbnail_${videoId}"
        )
        findNavController().navigate(action, extras)
    }

    override fun onTravelSpotClick(item: UiModel) {
        when (item) {
            is UiModel.InfoModel -> {
                // InfoModel에 대한 클릭 이벤트 처리
                if (favoriteTravelSpotViewModel.isFavorite(args.travelSpot.id)) {
                    // 좋아요 해제
                    favoriteTravelSpotViewModel.removeFavoriteItem(args.travelSpot)
                    Toast.makeText(context, "좋아요 목록에 추가하였습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    // 좋아요 추가
                    favoriteTravelSpotViewModel.addFavoriteItem(args.travelSpot)
                    Toast.makeText(context, "좋아요 취소하였습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            is UiModel.ViewPagerModel -> {
                // ViewPagerModel에 대한 클릭 이벤트 처리
                Toast.makeText(context, "ViewPager clicked!", Toast.LENGTH_SHORT).show()
            }
            is UiModel.TravelVideoListModel -> {
                // TravelVideoListModel에 대한 클릭 이벤트 처리
                Toast.makeText(context, "Video List clicked!", Toast.LENGTH_SHORT).show()
            }
            is UiModel.ChipGroupModel -> {
                // ChipGroupModel에 대한 클릭 이벤트 처리
                Toast.makeText(context, "${item.city} clicked!", Toast.LENGTH_SHORT).show()
            }
            is UiModel.VideoListLoadingUiModel -> {
                // VideoListLoadingUiModel에 대한 클릭 이벤트 처리
                Toast.makeText(context, "Loading clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Args 확인 OnResume", "${args.travelSpot.id}")
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
        val marginBottom = when (position) {
            0 -> px * 16
            1 -> px * 32
            2 -> px * 16
            else -> 0
        }
        outRect.bottom = marginBottom
    }
}


//private fun insertVideo(video: List<VideoEntity>) {
//    viewLifecycleOwner.lifecycleScope.launch {
//        val videoDb =
//            VideoRoomDB.getDatabase((requireActivity().applicationContext as PungsunTagoApplication))
//        videoDb.videoDao().insert(video)
//    }
//}