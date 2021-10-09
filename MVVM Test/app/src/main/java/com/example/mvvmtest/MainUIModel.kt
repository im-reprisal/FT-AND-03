package com.example.mvvmtest

import com.example.mvvmtest.data.models.ResponseDTO

sealed class MainUIModel {

    data class OnSuccess(val responseDTO: ResponseDTO) : MainUIModel()

    data class onFailure(val error: String) : MainUIModel()
}
