package com.example.myandroidbook.di

import android.content.Context
import androidx.room.Room
import com.example.myandroidbook.data.local.AndroidDataBase
import com.example.myandroidbook.util.Constant.ANDROID_TABLE_MODEL_DATABASE_KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AndroidDataBase {
        return Room.databaseBuilder(
            context,
            AndroidDataBase::class.java,
            ANDROID_TABLE_MODEL_DATABASE_KEY
        ).build()
    }

}