package com.example.myandroidbook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myandroidbook.util.Constant.ANDROID_TABLE_MODEL_DATABASE_KEY

@Entity(tableName = ANDROID_TABLE_MODEL_DATABASE_KEY)
data class AndroidModel (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val image: String,
    val about: String,
    val tags : List<String>,
    val ranking: Int,
    val yearRelease: Int,
    val difficulty : String
)