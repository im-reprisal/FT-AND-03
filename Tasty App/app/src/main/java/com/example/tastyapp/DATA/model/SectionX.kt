package com.example.TastyApp.DATA.model

import java.io.Serializable

data class SectionX(
    val components: List<ComponentX>,
    val name: Any,
    val position: Int
):Serializable