package com.example.search.api
import com.example.search.data.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("compassLocation/rest/address/autocomplete")
    suspend fun getCityName(
        @Query("queryString") queryString: String,
        @Query("city") city: String,
    ): ResponseModel
}