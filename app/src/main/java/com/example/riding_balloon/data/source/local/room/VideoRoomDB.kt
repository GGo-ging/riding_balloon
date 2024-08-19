package com.example.riding_balloon.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import javax.inject.Inject

@Database(entities = [VideoEntity::class], version = 1)
abstract class VideoRoomDB : RoomDatabase() {
    abstract fun videoDao(): VideoDao

    companion object {
        private var INSTANCE : VideoRoomDB ?= null

        fun getDatabase(context: Context) : VideoRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VideoRoomDB::class.java,
                    "videoRoomDatabase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}