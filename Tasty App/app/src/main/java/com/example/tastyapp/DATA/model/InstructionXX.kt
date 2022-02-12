package com.example.TastyApp.DATA.model

import java.io.Serializable

data class InstructionXX(
    val appliance: Any,
    val display_text: String,
    val end_time: Int,
    val id: Int,
    val position: Int,
    val start_time: Int,
    val temperature: Any
):Serializable