package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface APIClient {

    @GET("movie/popular/?api_key=f49627c11b64cac52e095433e9c2e598")
    fun getAPIResponse(): Call<List<ResponseModel>>
}