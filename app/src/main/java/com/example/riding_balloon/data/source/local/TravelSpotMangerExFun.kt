package com.example.riding_balloon.data.source.local

import com.example.riding_balloon.data.model.TravelSpotInfo

fun TravelSpotManager.getTravelSpotByArg(id: Int) : TravelSpotInfo {
    return this.getTravelSpots().first {
        it.id == id
    }
}