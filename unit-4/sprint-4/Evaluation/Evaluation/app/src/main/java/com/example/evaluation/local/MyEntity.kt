package com.example.evaluation.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_cart_table")
data class MyEntity(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "price") val price: Double
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}