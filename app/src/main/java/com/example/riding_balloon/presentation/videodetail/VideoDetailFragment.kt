package com.example.riding_balloon.presentation.videodetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.util.Util
import com.example.riding_balloon.databinding.FragmentVideoDetailBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
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

        val player = binding.ypYoutubePlayer
        lifecycle.addObserver(player)

        player.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)

                val videoId = "uUd93EEPP3E"
                youTubePlayer.loadVideo(videoId, 0F)
            }
        })

        binding.btnShareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"

            val url = "https://youtu.be/uUd93EEPP3E?si=sGXVpAXangED822n"
            val content = "링크 공유를 할 수 있습니다. 어디에 공유 할까요?"
            intent.putExtra(Intent.EXTRA_TEXT,"$content\n\n$url")

            val chooseTitle = "친구에게 공유하기"
            startActivity(Intent.createChooser(intent, chooseTitle))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}