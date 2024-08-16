package com.example.riding_balloon.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TravelSpotInfo(
    val id: Int,
    val thumbnailUrl: String, // 3장 밖에 안 모아서 images에서 첫 번째 이미지로 대체해도 됨
    val country: String,
    val region: String,
    val description: String,
    val images: List<String>,
    val ranking: Int = 0 // (1 ~ 10위 / 해당 안 되는 국가는 0)
) : Parcelable
