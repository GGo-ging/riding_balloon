package com.example.riding_balloon.data.repository.travelspotdetail

import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotInfoUiModel

interface TravelSpotRepository {
    fun getTravelSpots(id: Int): TravelSpotInfo
    fun getTravelSpotUiModel(id: Int): TravelSpotInfoUiModel
    fun getTravelSpotCountryAndRegion(id: Int): Pair<String, String>
}