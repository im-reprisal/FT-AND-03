package com.masai.myapplication.network

import com.masai.myapplication.data.models.ResponseDTO
import retrofit2.http.GET

interface ApiService {

    //https://api.themoviedb.org/
    @GET("3/movie/popular?api_key=f49627c11b64cac52e095433e9c2e598")
    suspend fun getAPIResponse(): ResponseDTO
}