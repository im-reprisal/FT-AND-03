package com.example.my.data.repository

import com.example.my.data.models.Article
import com.example.my.network.ServiceGenerator

class MainRepository {
    suspend fun getResponseFromAPI() : List<Article>{
        return ServiceGenerator.getApiService().getAPIResponse().articles
    }
}