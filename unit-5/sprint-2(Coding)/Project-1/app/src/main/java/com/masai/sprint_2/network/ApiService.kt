package com.masai.sprint_2.network

import com.masai.sprint_2.data.models.PeopleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("people")
    suspend fun getApiResponse(@Query("page") page:Int) : PeopleResponse
}