package com.example.myandroidbook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myandroidbook.util.Constant.ANDROID_REMOTE_DATABASE_KEYS


@Entity(tableName = ANDROID_REMOTE_DATABASE_KEYS)
data class AndroidRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
