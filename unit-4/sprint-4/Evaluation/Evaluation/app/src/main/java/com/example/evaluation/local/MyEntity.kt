package com.example.evaluation.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_cart_table")
data class MyEntity(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "crust") val crust: String,
    @ColumnInfo(name = "price") val price: Double
)