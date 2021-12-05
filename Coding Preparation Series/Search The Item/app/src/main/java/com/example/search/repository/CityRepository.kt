package com.example.search.repository

import com.example.search.api.ServiceGenerator
import com.example.search.data.ResponseModel

class CityRepository {
    suspend fun getAllCities(query: String): ResponseModel {
        return ServiceGenerator.getApiService().getCityName("airtel", query)
    }
}