package com.example.riding_balloon.data.repository

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo
import com.example.riding_balloon.util.Constants.PREF_FAVORITE
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(context: Context) : FavoriteRepository {

    private val gson = GsonBuilder().registerTypeAdapter(FavoriteVideoInfo::class.java, CustomDeserializer()).create()
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_FAVORITE, Context.MODE_PRIVATE)
    private val _favoriteVideos = loadFavoriteVideos()

    override val favoriteVideos: List<FavoriteVideoInfo>
        get() = _favoriteVideos.toList()

    override fun addFavoriteVideo(video: FavoriteVideoInfo) {
        if (_favoriteVideos.find { it.videoId == video.videoId } == null) {
            _favoriteVideos.add(0, video)
            saveFavoriteVideos()
        }
    }

    override fun removeFavoriteVideo(video: FavoriteVideoInfo) {
        _favoriteVideos.remove(video)
        saveFavoriteVideos()
    }

    override fun saveFavoriteVideos() {
        val json = gson.toJson(_favoriteVideos)
        sharedPreferences.edit().putString(PREF_FAVORITE, json).apply()
    }

    override fun loadFavoriteVideos(): MutableList<FavoriteVideoInfo> {
        val json = sharedPreferences.getString(PREF_FAVORITE, null) ?: return mutableListOf()
        val type = object : TypeToken<MutableList<FavoriteVideoInfo>>() {}.type
        return gson.fromJson(json, type)
    }

    override fun isFavorite(videoId: String): Boolean {
        val video = _favoriteVideos.find { it.videoId == videoId }
        if (video == null) {
            Log.d("FavoriteRepositoryImpl", "isFavorite: $videoId, false")
            return false
        } else {
            Log.d("FavoriteRepositoryImpl", "isFavorite: $videoId, true")
        }
        return true
    }
}