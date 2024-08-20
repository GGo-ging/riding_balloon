package com.example.riding_balloon.presentation.travelspotdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.riding_balloon.databinding.FragmentGptLoadingBinding

class GptLoadingFragment : Fragment() {

    private val binding by lazy { FragmentGptLoadingBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}