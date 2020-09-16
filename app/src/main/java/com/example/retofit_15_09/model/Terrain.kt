package com.example.retofit_15_09.model

import com.google.gson.annotations.SerializedName

data class Terrain(val price: Long,
                   val id: String,
                   val type: String,
                   @SerializedName("img_src")val imgSrc: String)
