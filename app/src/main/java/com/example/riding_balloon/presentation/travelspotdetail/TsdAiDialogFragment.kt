package com.example.riding_balloon.presentation.travelspotdetail

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.riding_balloon.databinding.FragmentTsdAiBottomSheetBinding
import io.noties.markwon.Markwon

class TsdAiDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBinding = FragmentTsdAiBottomSheetBinding.inflate(layoutInflater)

        val aiViewModel by activityViewModels<AiBottomSheetViewModel>()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(dialogBinding.tvAiMessage, aiViewModel.aiMessage.value ?: "")

        dialogBinding.ivTravelCloseBtn.setOnClickListener {
            dismiss()
        }

//        dialogBinding.tvAiMessage.text = aiViewModel.aiMessage.value

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(dialogBinding.root)

        return builder.create()
    }
}