package com.example.myapplication

data class ResponseModel(
    val crusts: List<Crust>,
    val defaultCrust: Int,
    val description: String,
    val isVeg: Boolean,
    val name: String
)