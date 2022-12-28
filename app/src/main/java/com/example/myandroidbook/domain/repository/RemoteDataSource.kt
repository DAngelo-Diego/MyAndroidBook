package com.example.myandroidbook.domain.repository

import androidx.paging.PagingData
import com.example.myandroidbook.domain.model.AndroidModel
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllAndroidInfoRemoteSource(): Flow<PagingData<AndroidModel>>
    fun searchAndroidInfoRemoteSource(): Flow<PagingData<AndroidModel>>

}