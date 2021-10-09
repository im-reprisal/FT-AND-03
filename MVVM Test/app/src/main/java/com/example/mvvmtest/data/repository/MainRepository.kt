package com.example.mvvmtest.data.repository

import com.example.mvvmtest.data.models.ResponseDTO
import com.example.mvvmtest.network.ServiceGenerator

class MainRepository {

    suspend fun getAllCharacters(): ResponseDTO {
        return ServiceGenerator.getApiService().getAllCharacters()
    }
}