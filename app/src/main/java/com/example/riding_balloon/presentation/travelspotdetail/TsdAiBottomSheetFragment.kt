package com.example.riding_balloon.presentation.travelspotdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.riding_balloon.R
import com.example.riding_balloon.databinding.FragmentTsdAiBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TsdAiBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentTsdAiBottomSheetBinding? = null
    private val binding get() = _binding!!

    private val aiViewModel by activityViewModels<AiBottomSheetViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTsdAiBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aiViewModel.aiMessage.observe(viewLifecycleOwner) {
            binding.tvAiMessage.text = it
        }
    }

}