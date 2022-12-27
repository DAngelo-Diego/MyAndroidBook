package com.example.myandroidbook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myandroidbook.data.local.dao.AndroidDao
import com.example.myandroidbook.data.local.dao.AndroidDaoRemoteKey
import com.example.myandroidbook.domain.model.AndroidModel
import com.example.myandroidbook.domain.model.AndroidRemoteKey


@Database(entities = [AndroidModel::class,AndroidRemoteKey::class], version = 1)
@TypeConverters(DataBaseConverter::class)
abstract class AndroidDataBase: RoomDatabase() {

    abstract fun androidDao(): AndroidDao
    abstract fun androidDaoRemoteKey(): AndroidDaoRemoteKey

}