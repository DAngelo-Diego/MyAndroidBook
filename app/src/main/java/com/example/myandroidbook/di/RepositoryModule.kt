package com.example.myandroidbook.di

import com.example.myandroidbook.data.repository.Repository
import com.example.myandroidbook.domain.use_cases.UseCases
import com.example.myandroidbook.domain.use_cases.get_all_android_info.GetAllAndroidInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            getAllAndroidInfoUseCase = GetAllAndroidInfoUseCase(repository = repository)
        )
    }
}