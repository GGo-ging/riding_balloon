package com.example.riding_balloon.data.repository.favoritetravelspot

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.data.repository.FavoriteTravelSpotDeserializer
import com.example.riding_balloon.util.Constants.PREF_FAVORITE_TRAVEL_SPOTS
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class FavoriteTravelSpotRepositoryImpl @Inject constructor(context: Context) : FavoriteTravelSpotRepository {

    private val gson = GsonBuilder().registerTypeAdapter(TravelSpotInfo::class.java, FavoriteTravelSpotDeserializer()).create()
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_FAVORITE_TRAVEL_SPOTS, Context.MODE_PRIVATE)
    private val _favoriteTravelSpots = loadFavoriteTravelSpots()

    override val favoriteTravelSpots: List<TravelSpotInfo>
        get() = _favoriteTravelSpots.toList()

    override fun addFavoriteTravelSpot(travelSpot: TravelSpotInfo) {
        if (_favoriteTravelSpots.find { it.id == travelSpot.id } == null) {
            _favoriteTravelSpots.add(0, travelSpot)
            Log.d("FavoriteTravelSpotRepositoryImpl", "addFavoriteTravelSpot: $travelSpot")
            saveFavoriteTravelSpots()
        }
    }

    override fun removeFavoriteTravelSpot(travelSpot: TravelSpotInfo) {
        _favoriteTravelSpots.remove(travelSpot)
        saveFavoriteTravelSpots()
    }

    override fun removeMultipleFavoriteTravelSpots(travelSpots: List<TravelSpotInfo>) {
        _favoriteTravelSpots.removeAll(travelSpots)
        saveFavoriteTravelSpots()
    }

    override fun saveFavoriteTravelSpots() {
        val json = gson.toJson(_favoriteTravelSpots)
        sharedPreferences.edit().putString(PREF_FAVORITE_TRAVEL_SPOTS, json).apply()
    }

    override fun loadFavoriteTravelSpots(): MutableList<TravelSpotInfo> {
        val json = sharedPreferences.getString(PREF_FAVORITE_TRAVEL_SPOTS, null) ?: return mutableListOf()
        val type = object : TypeToken<MutableList<TravelSpotInfo>>() {}.type
        return gson.fromJson(json, type)
    }

    override fun isFavorite(travelSpotId: Int): Boolean {
        val travelSpot = _favoriteTravelSpots.find { it.id == travelSpotId }
        return travelSpot != null
        //return true
    }
}