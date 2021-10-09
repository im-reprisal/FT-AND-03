package com.example.myapplication

data class Crust(
    val defaultSize: Int,
    val id: Int,
    val name: String,
    val sizes: List<Size>
)