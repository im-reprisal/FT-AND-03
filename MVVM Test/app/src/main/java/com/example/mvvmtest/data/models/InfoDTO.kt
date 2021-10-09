package com.example.mvvmtest.data.models

import com.google.gson.annotations.SerializedName

data class InfoDTO(

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("pages")
    val pages: Int? = null,

    @field:SerializedName("next")
    val next: String? = null,

    @field:SerializedName("prev")
    val prev: Any? = null
)