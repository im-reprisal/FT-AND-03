package com.masai.sprint_1unit_5.data.models


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String
)