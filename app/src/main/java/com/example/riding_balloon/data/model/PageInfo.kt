package com.example.riding_balloon.data.model

import com.google.gson.annotations.SerializedName

data class PageInfo(
    @SerializedName("totalResults")
    val totalResults: Int?,
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int?
)
