package com.example.retofit_15_09.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "terrain_table")
data class Terrain(val price: Long,
                   @PrimaryKey val id: String,
                   val type: String,
                   @SerializedName("img_src")val imgSrc: String)
