package com.example.retrofit_1.models.remote.responses


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("age")
    val age: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("__v")
    val v: Int
)
