package com.example.riding_balloon.data.mapper

import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotInfoUiModel

fun TravelSpotInfo.toTravelSpotInfoUiModel() : TravelSpotInfoUiModel {
    return TravelSpotInfoUiModel(
        id = id,
        images = images,
        country = country,
        region = region,
        description = description,
    )
}

fun TravelSpotInfo.toTravelSpotCountryAndRegion() : Pair<String, String> {
    return Pair(country, region)
}