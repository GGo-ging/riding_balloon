package com.example.riding_balloon.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.riding_balloon.R
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var searchAdapter: SearchFragmentAdapter

    private val countriesByContinent = mapOf(
        "아시아" to listOf("일본", "중국", "베트남", "말레시아", "인도네시아", "대만", "홍콩", "태국", "튀르키예","필리핀", "싱가포르"),
        "유럽" to listOf("프랑스", "오스트리아", "영국", "이탈리아", "독일", "그리스", "스위스", "덴마크", "노르웨이", "벨기에", "스페인", "포르투갈"),
        "아프리카" to listOf("이집트"),
        "아메리카" to listOf("미국", "캐나다", "브라질", "아르헨티나"),
        "오세아니아" to listOf("호주", "괌")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchAdapter = SearchFragmentAdapter(TravelSpotManager.getTravelSpots())
        binding.recyclerViewSearch.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerViewSearch.adapter = searchAdapter

        val continentAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_items_continent,
            android.R.layout.simple_spinner_item
        )
        continentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerContinent.adapter = continentAdapter

        val countryAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listOf("나라"))
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCountry.adapter = countryAdapter

//        val continents = listOf("대륙") + countriesByContinent.keys.toList()
//        val continentAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, continents)
//        continentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        binding.spinnerContinent.adapter = continentAdapter
//
//        val countryAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listOf("나라"))
//        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        binding.spinnerCountry.adapter = countryAdapter

//        ArrayAdapter.createFromResource(
//            requireContext(),
//            R.array.spinner_items_continent,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            binding.spinnerContinent.adapter = adapter
//        }

        binding.spinnerContinent.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedContinent = parent.getItemAtPosition(position) as String
                if (selectedContinent == "대륙") {
                    binding.spinnerCountry.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listOf("나라"))
                    updateRecyclerView(null)
                } else {
                    val countries = listOf("나라") + (countriesByContinent[selectedContinent] ?: emptyList())
                    val newCountryAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, countries)
                    newCountryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.spinnerCountry.adapter = newCountryAdapter

                    updateRecyclerView(countries[1])
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCountry = parent.getItemAtPosition(position) as String
                if (selectedCountry == "나라") {
                    updateRecyclerView(null)
                } else {
                    updateRecyclerView(selectedCountry)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }

    private fun updateRecyclerView(selectedCountry: String?) {
        val filteredSpots = if (selectedCountry == null) {
            TravelSpotManager.getTravelSpots()
        } else {
            TravelSpotManager.getTravelSpots().filter { it.country == selectedCountry }
        }
        searchAdapter.updateData(filteredSpots)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}