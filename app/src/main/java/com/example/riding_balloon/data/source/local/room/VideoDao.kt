package com.example.riding_balloon.data.source.local.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VideoDao {
    @Query("SELECT * FROM video_table ORDER BY video_view_count DESC")
    fun getAll(): PagingSource<Int, VideoEntity>

    @Query("DELETE FROM video_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(videos: List<VideoEntity>)
}
