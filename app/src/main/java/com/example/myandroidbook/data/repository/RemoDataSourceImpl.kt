package com.example.myandroidbook.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myandroidbook.data.local.AndroidDataBase
import com.example.myandroidbook.data.paging_source.AndroidRemoteMediator
import com.example.myandroidbook.data.remote.AndroidApi
import com.example.myandroidbook.domain.model.AndroidModel
import com.example.myandroidbook.domain.repository.RemoteDataSource
import com.example.myandroidbook.util.Constant.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow


@OptIn(ExperimentalPagingApi::class)
class RemoDataSourceImpl(
    private val androidApi: AndroidApi,
    private val androidDataBase: AndroidDataBase
): RemoteDataSource {

    private val androidDao = androidDataBase.androidDao()

    override fun getAllAndroidInfoRemoteSource(): Flow<PagingData<AndroidModel>> {
        val pagingSourceFactory = { androidDao.getAllAndroidInfo() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = AndroidRemoteMediator(
                androidApi = androidApi,
                androidDataBase = androidDataBase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchAndroidInfoRemoteSource(): Flow<PagingData<AndroidModel>> {
        TODO("Not yet implemented")
    }


}