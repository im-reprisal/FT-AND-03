package com.masai.sprint_2.data.models


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: Self
)