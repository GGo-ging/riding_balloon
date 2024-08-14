package com.example.riding_balloon.presentation.videodetail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.riding_balloon.databinding.FragmentVideoDetailBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class VideoDetailFragment : Fragment() {

    private var _binding: FragmentVideoDetailBinding? = null
    private val binding get() = _binding!!

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

        val url = "https://youtu.be/uUd93EEPP3E?si=sGXVpAXangED822n"
        val title = "안녕하세요"
        val subtitle = "안녕하세요안녕하세요안녕하세요안녕하세요"
        val description = "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요" +
                "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요"

        val player = binding.ypYoutubePlayer
        lifecycle.addObserver(player)

        player.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)

                val videoId = videoId(url)
                if (videoId != null) {
                    youTubePlayer.loadVideo(videoId, 0F)
                } else {
                    Toast.makeText(requireContext(), "URL이 잘못 되어서 동영상을 불러올 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.tvDetailPageMainTitle.text = title
        binding.tvDetailPageSubTitle.text = subtitle
        binding.tvDetailText.text = description

        binding.btnShareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"

            val shareUrl = "https://youtu.be/uUd93EEPP3E?si=sGXVpAXangED822n"
            val content = "링크 공유를 할 수 있습니다. 어디에 공유 할까요?"
            intent.putExtra(Intent.EXTRA_TEXT,"$content\n\n$shareUrl")

            val chooseTitle = "친구에게 공유하기"
            startActivity(Intent.createChooser(intent, chooseTitle))
        }
    }

    private fun videoId(url: String?): String? {
        if (url == null) return null

        val pattern = listOf(
            Regex("v=([a-zA-Z0-9_-]{11})"),
            Regex("youtu.be/([a-zA-Z0-9_-]{11})")
        )
        for (regex in pattern) {
            val match = regex.find(url)
            if (match != null) {
                return match.groupValues[1]
            }
        }

        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}