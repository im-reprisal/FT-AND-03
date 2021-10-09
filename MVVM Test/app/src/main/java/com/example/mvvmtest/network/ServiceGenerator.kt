package com.example.mvvmtest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//
object ServiceGenerator {

    private fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiService() = getRetrofit().create(ApiService::class.java)
}