package com.example.mvvmtest.data.models

import com.google.gson.annotations.SerializedName


data class ResultsDTO(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("species")
    val species: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("origin")
    val origin: OriginDTO? = null,

    @field:SerializedName("location")
    val location: LocationDTO? = null,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("episode")
    val episode: List<String?>? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("created")
    val created: String? = null
)