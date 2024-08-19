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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.riding_balloon.R
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.databinding.FragmentTravelSpotDetailBinding
import com.google.android.material.chip.Chip
import kotlin.math.roundToInt

class TravelSpotDetailFragment : Fragment() {

    private var _binding: FragmentTravelSpotDetailBinding? = null
    private val binding get() = _binding!!

    private val recyclerViewAdapter = TravelSpotDetailRecyclerViewAdapter()

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

        // args.travelSpot으로 가져오면 됨.
        Log.d("TravelSpotDetailFragment", "args: ${args.travelSpot}")

        recyclerViewAdapter.submitList(
            listOf(
                UiModel.ViewPagerModel(imageUrlList = TravelSpotManager.getListByCountry()[0].images),
                UiModel.InfoModel(
                    nation = TravelSpotManager.getListByCountry()[0].country,
                    city = TravelSpotManager.getListByCountry()[0].region,
                    desc = TravelSpotManager.getListByCountry()[0].description
                ),
                UiModel.TravelVideoListModel()
            )
        )

        binding.rvTravel.adapter = recyclerViewAdapter
        binding.rvTravel.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTravel.addItemDecoration(TsdRecyclerViewSpaceDecoration((resources.displayMetrics.density).roundToInt()))

        recyclerViewAdapter.drawImage = TravelSpotDetailRecyclerViewAdapter.DrawImage { url ->
            Glide.with(this).load(url)
        }

        recyclerViewAdapter.addChips = TravelSpotDetailRecyclerViewAdapter.AddChips { group ->
            val stringArray: Array<String> = resources.getStringArray(R.array.travel_chips)
            for(str in stringArray) {
                val chip = Chip(context)
                chip.text = "#$str"
//                chip.setBackgroundResource(R.drawable.travel_sel_chip_click)
                // d
                chip.setOnClickListener {
                    Log.d("Chip", "chip clicked $chip")
                }
                group.addView(chip)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
        val marginBottom = when(position) {
            0 -> px * 16
            1 -> px * 32
            else -> 0
        }
        outRect.bottom = marginBottom
    }
}