package com.masai.sprint_1unit_5.network

import com.masai.sprint_1unit_5.data.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("people")
    fun getApiData(@Query("page") page: Int): ResponseModel

    @GET("people")
    suspend fun getApiResponse(@Query("page") page:Int) : ResponseModel
}