package com.example.TastyApp.REMOTE

import com.example.TastyApp.DATA.model.ItemX
import com.example.TastyApp.DATA.model.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("feeds/list")
    suspend fun getData(
        @Query("size") size: Int = 20,
        @Query("timezone") timezone: String = "+0700",
        @Query("vegetarian") vegetarian: Boolean = false,
        @Query("from") from: Int = 0,
        @Header("x-rapidapi-host") host: String = "tasty.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "7469390914mshd43b5e3527cfab6p15ac36jsn07e559b13b9b"
    ): ResponseDTO

    @GET("recipes/detail")
    suspend fun getDetail(
        @Query("id") id: Int,
        @Header("x-rapidapi-host") host: String = "tasty.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "7469390914mshd43b5e3527cfab6p15ac36jsn07e559b13b9b"
    ): ItemX
}