package com.example.myandroidbook.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroidbook.domain.model.AndroidModel

@Dao
interface AndroidDao {

    @Query("SELECT * FROM android_database ORDER BY id ASC")
    fun getAllAndroidInfo(): PagingSource<Int, AndroidModel>

    @Query("SELECT * FROM android_database WHERE id=:infoId")
    fun getSelectedAndroid(infoId: Int): AndroidModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAndroidInfo(kotlinList: List<AndroidModel>)

    @Query("DELETE FROM android_database")
    suspend fun deleteAllInfo()
}