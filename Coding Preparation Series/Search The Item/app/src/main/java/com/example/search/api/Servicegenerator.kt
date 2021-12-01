package com.example.search.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://digi-api.airtel.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiService() = getRetrofit().create(ApiClient::class.java)

}