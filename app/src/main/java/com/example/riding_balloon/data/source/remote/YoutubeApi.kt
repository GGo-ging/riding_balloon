package com.example.riding_balloon.data.source.remote

import com.example.riding_balloon.data.model.SearchVideoResponse
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.VideoDetailResponse
import com.example.riding_balloon.util.Constants.API_KEY
import com.example.riding_balloon.util.Constants.API_MAX_RESULT_20
import com.example.riding_balloon.util.Constants.API_MAX_RESULT_50
import com.example.riding_balloon.util.Constants.API_REGION
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    // 인기 급상승 동영상 리스트 가져오기
    @GET("videos")
    suspend fun getTrendingVideos(
        @Query("part") part: String = "snippet,statistics",
        @Query("chart") chart: String = "mostPopular",
        @Query("regionCode") regionCode: String = API_REGION,
        @Query("maxResults") maxResults: Int = API_MAX_RESULT_50,
        @Query("key") key: String = API_KEY
    ): TrendingVideoResponse

    // 동영상 검색
    @GET("search")
    suspend fun searchVideos(
        @Query("part") part: String = "snippet",
        @Query("q") query: String,
        @Query("type") type: String = "video",
        @Query("maxResults") maxResults: Int = API_MAX_RESULT_20,
        @Query("key") key: String = API_KEY,
        @Query("videoCategoryId") videoCategoryId: String = "19",
    ): SearchVideoResponse

    // 동영상 검색, 조회수 순으로 정렬
    @GET("search")
    suspend fun searchVideosOrderByViewCount(
        @Query("part") part: String = "snippet",
        @Query("q") query: String,
        @Query("type") type: String = "video",
        @Query("maxResults") maxResults: Int = API_MAX_RESULT_20,
        @Query("key") key: String = API_KEY,
        @Query("videoCategoryId") videoCategoryId: String = "19",
        @Query("order") order: String = "viewCount",
    ): SearchVideoResponse

    // 동영상 상세 정보 가져오기
    @GET("videos")
    suspend fun getVideoDetail(
        @Query("part") part: String = "snippet,statistics",
        @Query("id") id: String,
        @Query("key") key: String = API_KEY
    ): VideoDetailResponse

}