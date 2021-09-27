package com.example.evaluation.api

import com.example.evaluation.models.PizzaResponse
import retrofit2.Response
import retrofit2.http.GET

interface PizzaApiService {
    @GET("shivarajp/04af4846333e3c61a8d84d310915c75d/raw/a8a1bd18d7ca7f59dc56784b211044864beba831/pizzas")
    suspend fun getPizza():Response<PizzaResponse>
}