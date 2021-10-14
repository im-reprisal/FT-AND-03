package com.masai.mypizzaassignment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The ApiServices class is responsible for making the api call by using Retrofit
 */
object ServiceGenerator {
    const val BASE_URL =
        "https://gist.githubusercontent.com/im-reprisal/31983ef088bde8d5cdc2da970c7deb97/raw/a587c5638389a228d321392d0313978647496313/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}