package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users/shivarajp/repos")
    fun getUserData(): Call<ResponseModel>
}