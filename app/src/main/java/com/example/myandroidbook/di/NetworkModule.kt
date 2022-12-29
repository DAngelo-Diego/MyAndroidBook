package com.example.myandroidbook.di

import com.example.myandroidbook.data.local.AndroidDataBase
import com.example.myandroidbook.data.remote.AndroidApi
import com.example.myandroidbook.data.repository.RemoDataSourceImpl
import com.example.myandroidbook.domain.repository.RemoteDataSource
import com.example.myandroidbook.util.Constant.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetroFitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideAndroidApi(retrofit: Retrofit) : AndroidApi {
        return retrofit.create(AndroidApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRemoteDataSource(
        androidApi: AndroidApi,
        androidDataBase: AndroidDataBase
    ): RemoteDataSource {
        return RemoDataSourceImpl(
            androidApi = androidApi,
            androidDataBase = androidDataBase
        )
    }

}