package com.example.myandroidbook.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroidbook.domain.model.AndroidRemoteKey

@Dao
interface AndroidDaoRemoteKey {
    @Query("SELECT * FROM android_remote_database_key WHERE id = :id")
    suspend fun getRemoteKey(id: Int): AndroidRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(androidRemoteKeys: List<AndroidRemoteKey>)

    @Query("DELETE FROM android_remote_database_key")
    suspend fun deleteAllRemoteKeys()
}