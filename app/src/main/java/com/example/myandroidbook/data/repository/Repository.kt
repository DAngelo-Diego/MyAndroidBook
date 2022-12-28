package com.example.myandroidbook.data.repository

import androidx.paging.PagingData
import com.example.myandroidbook.domain.model.AndroidModel
import com.example.myandroidbook.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource
) {

    fun getAllAndroidInfoRepository(): Flow<PagingData<AndroidModel>>{
        return remote.getAllAndroidInfoRemoteSource()
    }

}