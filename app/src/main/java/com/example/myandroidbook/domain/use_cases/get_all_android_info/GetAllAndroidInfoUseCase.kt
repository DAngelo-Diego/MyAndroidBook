package com.example.myandroidbook.domain.use_cases.get_all_android_info

import androidx.paging.PagingData
import com.example.myandroidbook.data.repository.Repository
import com.example.myandroidbook.domain.model.AndroidModel
import kotlinx.coroutines.flow.Flow

class GetAllAndroidInfoUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<AndroidModel>>{
        return repository.getAllAndroidInfoRepository()
    }

}