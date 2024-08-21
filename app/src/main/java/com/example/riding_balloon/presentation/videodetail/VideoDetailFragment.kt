package com.example.riding_balloon.presentation.videodetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.riding_balloon.R
import com.example.riding_balloon.data.model.VideoItem
import androidx.navigation.fragment.navArgs
import com.example.riding_balloon.databinding.FragmentVideoDetailBinding
import com.example.riding_balloon.presentation.extensions.toFavoriteVideoInfo
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo
import com.example.riding_balloon.presentation.viewmodel.FavoriteViewModel
import com.example.riding_balloon.presentation.MainActivity
import com.example.riding_balloon.presentation.extensions.load
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import java.text.DecimalFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class VideoDetailFragment : Fragment() {

    private var _binding: FragmentVideoDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: VideoDetailViewModel by activityViewModels()
    private lateinit var url: String

    private val args: VideoDetailFragmentArgs by navArgs() // 네비게이션으로 전달받은 인자를 사용하기 위한 변수

    private lateinit var video: VideoItem
    private lateinit var favoriteVideoItem: FavoriteVideoInfo

    private val favoriteViewModel by activityViewModels<FavoriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoDetailBinding.inflate(inflater, container, false)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        binding.ivYoutubePlayer.apply {
            transitionName = "thumbnail_${args.videoId}"
            load(args.thumbnailUrl)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // args.videoId로 영상 정보를 가져옴
        Log.d("VideoDetailFragment", "args.videoId: ${args.videoId}")

        url = "https://www.youtube.com/watch?v=${args.videoId}"
        //url = "https://youtu.be/_UyQLveYyzI?si=4Uh2TVQ1MNwvR7ik"

        val videoId = args.videoId
            viewModel.videoDetailsGet(videoId)

        val player = binding.ypYoutubePlayer
        lifecycle.addObserver(player)

        player.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                binding.ivYoutubePlayer.visibility = View.GONE

                    youTubePlayer.loadVideo(videoId, 0F)
            }
        })

        viewModel.videoDetail.observe(viewLifecycleOwner) { videoItem ->
            video = videoItem.items?.firstOrNull() ?: VideoItem(null, null, null, null, null)

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val dateTime = OffsetDateTime.parse(video.snippet?.publishedAt)
            val dataTimeFormat = dateTime?.format(formatter)

            val viewCount = video.statistics?.viewCount?.toLong() ?: 0L
            val formatPattern = DecimalFormat("#,###")
            val formatViewCount = formatPattern.format(viewCount)

            with(binding) {
                tvDetailPageMainTitle.text = video.snippet?.title
                tvDetailPageSubTitle.text = getString(R.string.video_detail_subtitle, video.snippet?.channelTitle, formatViewCount, dataTimeFormat)
                tvDetailText.text = video.snippet?.description
            }
        }

        binding.btnShareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"

            val content = "링크를 어디에 공유할까요"
            intent.putExtra(Intent.EXTRA_TEXT, "$content\n\n$url")

            val chooseTitle = "친구에게 공유하기"
            startActivity(Intent.createChooser(intent, chooseTitle))
        }

        binding.ivBackBarImage.setOnClickListener {
            // 메인 화면으로 돌아감
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

            initFavoriteButton(videoId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initFavoriteButton(videoId: String) = with(binding) {
        var isFavorite = favoriteViewModel.isFavorite(videoId)
        Log.d("VideoDetailFragment", "isFavorite: $isFavorite")
//        if (isFavorite) {
//            ivBackBarHeart.setImageResource(R.drawable.ic_heart)
//        } else {
//            ivBackBarHeart.setImageResource(R.drawable.ic_heart_border)
//        }
        ivBackBarHeart.isSelected = isFavorite
        ivBackBarHeart.setOnClickListener {
            isFavorite = favoriteViewModel.isFavorite(videoId)
            Log.d("VideoDetailFragment", "isFavorite: $isFavorite")
            favoriteVideoItem = video.toFavoriteVideoInfo()
            if (isFavorite) {
                Log.d("VideoDetailFragment", "removeFavoriteItem: $favoriteVideoItem")
                favoriteViewModel.removeFavoriteItem(favoriteVideoItem)
                ivBackBarHeart.isSelected = false
                Toast.makeText(requireContext(), "좋아요 취소하였습니다.", Toast.LENGTH_SHORT).show()
            } else {
                favoriteViewModel.addFavoriteItem(favoriteVideoItem)
                ivBackBarHeart.isSelected = true
                Toast.makeText(requireContext(), "좋아요 목록에 추가하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
