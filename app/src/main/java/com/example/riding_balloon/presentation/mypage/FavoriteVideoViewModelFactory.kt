package com.example.riding_balloon.presentation.mypage

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.riding_balloon.data.repository.FavoriteVideoRepository

//class FavoriteVideoViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return when {
//            modelClass.isAssignableFrom(FavoriteVideoViewModel::class.java) -> {
//                FavoriteViewModel(FavoriteVideoRepository()) as T
//            }
//            else -> throw IllegalArgumentException("Unknown ViewModel class")
//        }
//    }
//}