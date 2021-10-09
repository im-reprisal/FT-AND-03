package com.example.mvvmtest.data.models

import com.google.gson.annotations.SerializedName

data class OriginDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)