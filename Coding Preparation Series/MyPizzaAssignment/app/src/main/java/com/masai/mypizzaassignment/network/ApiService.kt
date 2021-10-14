package com.masai.mypizzaassignment.network

import com.masai.mypizzaassignment.data.models.PizzaResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("Pizza%2520json")
    suspend fun getPizza(): Response<PizzaResponse>
}