package com.example.TastyApp.DATA.model

import java.io.Serializable

data class UserRatingsX(
    val count_negative: Int,
    val count_positive: Int,
    val score: Double
):Serializable