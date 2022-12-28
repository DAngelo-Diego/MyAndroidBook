package com.example.myandroidbook.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.myandroidbook.data.local.AndroidDataBase
import com.example.myandroidbook.data.remote.AndroidApi
import com.example.myandroidbook.domain.model.AndroidModel
import com.example.myandroidbook.domain.model.AndroidRemoteKeys
import javax.inject.Inject

@ExperimentalPagingApi
class AndroidRemoteMediator @Inject constructor(
    private val androidApi: AndroidApi,
    private val androidDataBase: AndroidDataBase
) : RemoteMediator<Int, AndroidModel>() {


    private val androidDao = androidDataBase.androidDao()
    private val androidRemoteKeysDao = androidDataBase.androidDaoRemoteKeys()


    override suspend fun load(
        loadType: LoadType, state: PagingState<Int,AndroidModel>
    ): MediatorResult {
        return try {

            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            val response = androidApi.getAllInfo(page = page)
            if (response.android.isNotEmpty()) {
                androidDataBase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        androidDao.deleteAllInfo()
                        androidRemoteKeysDao.deleteAllRemoteKeys()
                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.android.map { androidId ->
                        AndroidRemoteKeys(
                            id = androidId.id, prevPage = prevPage, nextPage = nextPage
                        )
                    }
                    androidRemoteKeysDao.addAllRemoteKeys(androidRemoteKeys = keys)
                    androidDao.addAndroidInfo(kotlinList = response.android)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }

    }


    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, AndroidModel>
    ): AndroidRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                androidRemoteKeysDao.getRemoteKeys(kotlinId = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, AndroidModel>
    ): AndroidRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { android ->
            androidRemoteKeysDao.getRemoteKeys(kotlinId = android.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, AndroidModel>)
    : AndroidRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { android ->
            androidRemoteKeysDao.getRemoteKeys(kotlinId = android.id)
            }
    }

}