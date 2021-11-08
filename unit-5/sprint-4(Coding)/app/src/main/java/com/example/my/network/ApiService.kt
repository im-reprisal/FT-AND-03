package com.example.my.network

import com.example.my.data.models.ResponseModel
import retrofit2.http.GET

interface ApiService {
    @GET("v2/everything?q=tesla&from=2021-10-08&sortBy=publishedAt&apiKey=24ee3463f67844e2b4d131595a0575ec")
    suspend fun getAPIResponse():ResponseModel
}