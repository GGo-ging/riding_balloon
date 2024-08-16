package com.example.riding_balloon.presentation.videodetail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.riding_balloon.databinding.FragmentVideoDetailBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class VideoDetailFragment : Fragment() {

    private var _binding: FragmentVideoDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel : VideoDetailViewModel by activityViewModels()
    private lateinit var url : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        url = "https://youtu.be/_UyQLveYyzI?si=4Uh2TVQ1MNwvR7ik"

        val videoId = videoIdSlice(url)
        if (videoId != null) {
            viewModel.videoDetailsGet(videoId)
        }

        val player = binding.ypYoutubePlayer
        lifecycle.addObserver(player)

        player.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)

                if (videoId != null) {
                    youTubePlayer.loadVideo(videoId, 0F)
                } else {
                    Toast.makeText(requireContext(), "영상을 불러올 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.videoDetail.observe(viewLifecycleOwner) { videoItem ->
            val video = videoItem.items?.firstOrNull()

            with(binding) {
                tvDetailPageMainTitle.text = video?.snippet?.title
                tvDetailPageSubTitle.text = "${video?.snippet?.channelTitle} · 조회수 ${video?.statistics?.viewCount}회"
                tvDetailText.text = video?.snippet?.description
            }
        }

        binding.btnShareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"

            val shareUrl = url
            val content = "링크 공유를 할 수 있습니다. 어디에 공유 할까요?"
            intent.putExtra(Intent.EXTRA_TEXT,"$content\n\n$shareUrl")

            val chooseTitle = "친구에게 공유하기"
            startActivity(Intent.createChooser(intent, chooseTitle))
        }

        binding.ivBackBarImage.setOnClickListener {
            // 메인 화면으로 돌아감
        }
    }

    private fun videoIdSlice(videoUrl: String?): String? {
        if (videoUrl == null) return null

        val videoIdPattern = listOf(
            Regex("v=([a-zA-Z0-9_-]{11})"),
            Regex("youtu.be/([a-zA-Z0-9_-]{11})")
        )
        for (videoIdSlice in videoIdPattern) {
            val sliceId = videoIdSlice.find(videoUrl)
            if (sliceId != null) {
                return sliceId.groupValues[1]
            }
        }

        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
