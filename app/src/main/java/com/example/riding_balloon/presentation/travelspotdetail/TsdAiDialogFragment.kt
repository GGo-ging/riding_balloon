package com.example.riding_balloon.presentation.travelspotdetail

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.riding_balloon.R
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}