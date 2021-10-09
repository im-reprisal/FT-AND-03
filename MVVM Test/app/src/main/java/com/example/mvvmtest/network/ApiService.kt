package com.example.mvvmtest.network

import com.example.mvvmtest.data.models.ResponseDTO
import retrofit2.http.GET

interface ApiService {

    @GET("api/character")
    suspend fun getAllCharacters(): ResponseDTO
}