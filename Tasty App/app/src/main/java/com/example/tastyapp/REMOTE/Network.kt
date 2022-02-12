package com.example.TastyApp.REMOTE

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Network {
    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://tasty.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api: ApiService = getRetrofit().create(ApiService::class.java)
    }
}