package com.example.riding_balloon.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.data.repository.favoritetravelspot.FavoriteTravelSpotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteTravelSpotViewModel @Inject constructor(
    private val repository: FavoriteTravelSpotRepository
) : ViewModel() {

    private val _favoriteTravelSpots = MutableLiveData<List<TravelSpotInfo>>()
    val favoriteTravelSpots: LiveData<List<TravelSpotInfo>> get() = _favoriteTravelSpots

    init {
        _favoriteTravelSpots.value = repository.loadFavoriteTravelSpots()
    }

    fun addFavoriteItem(item: TravelSpotInfo) {
        repository.addFavoriteTravelSpot(item)
        _favoriteTravelSpots.value = repository.favoriteTravelSpots
    }

    fun removeFavoriteItem(item: TravelSpotInfo) {
        repository.removeFavoriteTravelSpot(item)
        _favoriteTravelSpots.value = repository.favoriteTravelSpots
    }

    fun removeMultipleFavoriteItems(items: List<TravelSpotInfo>) {
        repository.removeMultipleFavoriteTravelSpots(items)
        _favoriteTravelSpots.value = repository.favoriteTravelSpots
    }

    fun saveFavoriteTravelSpots() {
        repository.saveFavoriteTravelSpots()
    }

    fun isFavorite(travelSpotId: Int): Boolean {
        return repository.isFavorite(travelSpotId)
    }
}