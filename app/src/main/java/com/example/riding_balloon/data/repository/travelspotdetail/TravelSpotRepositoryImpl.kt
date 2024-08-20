package com.example.riding_balloon.data.repository.travelspotdetail

import com.example.riding_balloon.data.mapper.toTravelSpotCountryAndRegion
import com.example.riding_balloon.data.mapper.toTravelSpotInfoUiModel
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.data.source.local.getTravelSpotByArg
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotInfoUiModel
import javax.inject.Inject

class TravelSpotRepositoryImpl @Inject constructor() : TravelSpotRepository {
    override fun getTravelSpots(id: Int): TravelSpotInfo {
        return TravelSpotManager.getTravelSpotByArg(id)
    }

    override fun getTravelSpotUiModel(id: Int): TravelSpotInfoUiModel {
        return getTravelSpots(id).toTravelSpotInfoUiModel()
    }

    override fun getTravelSpotCountryAndRegion(id: Int): Pair<String, String> {
        return getTravelSpots(id).toTravelSpotCountryAndRegion()
    }
}