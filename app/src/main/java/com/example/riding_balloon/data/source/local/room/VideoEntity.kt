package com.example.riding_balloon.data.source.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video_table")
data class VideoEntity(
    @ColumnInfo(name = "video_id")
    @PrimaryKey(autoGenerate = false)
    val videoId: String?,
    @ColumnInfo(name = "video_url")
    val videoUrl: String?,
    @ColumnInfo(name = "video_title")
    val videoTitle: String?,
    @ColumnInfo(name = "video_uploader")
    val videoUploader: String?,
    @ColumnInfo(name = "video_view_count")
    val videoViewCount: String?,
)
