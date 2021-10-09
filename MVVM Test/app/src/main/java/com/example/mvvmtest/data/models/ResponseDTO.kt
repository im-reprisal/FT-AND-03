package com.example.mvvmtest.data.models

import com.google.gson.annotations.SerializedName

data class ResponseDTO(

    @field:SerializedName("info")
    val info: InfoDTO? = null,

    @field:SerializedName("results")
    val results: List<ResultsDTO?>? = null
)