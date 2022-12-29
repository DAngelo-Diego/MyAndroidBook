package com.example.myandroidbook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myandroidbook.util.Constant.ANDROID_TABLE_MODEL_DATABASE_KEY
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = ANDROID_TABLE_MODEL_DATABASE_KEY)
data class AndroidModel (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val image: String,
    val about: String,
    val ranking: Double,
    val difficulty: String,
    val tags: List<String>,
    val yearRelease: String
)