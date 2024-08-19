package com.example.riding_balloon.data.repository.favoritetravelspot

import com.example.riding_balloon.data.model.TravelSpotInfo

interface FavoriteTravelSpotRepository {

    val favoriteTravelSpots: List<TravelSpotInfo>

    fun addFavoriteTravelSpot(travelSpot: TravelSpotInfo)

    fun removeFavoriteTravelSpot(travelSpot: TravelSpotInfo)

    fun removeMultipleFavoriteTravelSpots(travelSpots: List<TravelSpotInfo>)

    fun saveFavoriteTravelSpots()

    fun loadFavoriteTravelSpots(): MutableList<TravelSpotInfo>

    fun isFavorite(travelSpotId: Int): Boolean
}