package com.example.TastyApp.DATA.model

import java.io.Serializable

data class NutritionXX(
    val calories: Int,
    val carbohydrates: Int,
    val fat: Int,
    val fiber: Int,
    val protein: Int,
    val sugar: Int,
    val updated_at: String
):Serializable