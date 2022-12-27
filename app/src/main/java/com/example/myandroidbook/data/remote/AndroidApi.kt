package com.example.myandroidbook.data.remote

import com.example.myandroidbook.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AndroidApi {

    @GET("/android/info")
    suspend fun getAllInfo(
        @Query("page") page: Int = 1
    ) : ApiResponse

    @GET("/android/info/search")
    suspend fun searchInfo(
        @Query("title") title: String
    ): ApiResponse
}