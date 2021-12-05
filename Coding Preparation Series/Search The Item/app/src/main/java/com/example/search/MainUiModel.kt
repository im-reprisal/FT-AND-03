package com.example.search

import com.example.search.data.ResponseModel

sealed class MainUiModel{
    data class OnSuccess(val responseDTO: ResponseModel) : MainUiModel()

    data class OnFailure(val error: String) : MainUiModel()
}
