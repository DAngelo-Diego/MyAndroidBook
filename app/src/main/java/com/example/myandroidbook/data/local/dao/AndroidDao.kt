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
    fun getAllHeroes(): PagingSource<Int, AndroidModel>

    @Query("SELECT * FROM android_database WHERE id=:heroId")
    fun getSelectedHero(heroId: Int): AndroidModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroes: List<AndroidModel>)

    @Query("DELETE FROM android_database")
    suspend fun deleteAllHeroes()
}