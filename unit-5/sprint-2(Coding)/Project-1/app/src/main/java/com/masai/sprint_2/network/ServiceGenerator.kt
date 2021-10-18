package com.masai.sprint_2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl("https://api.tvmaze.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiService() = getRetrofit().create(ApiService::class.java)
}