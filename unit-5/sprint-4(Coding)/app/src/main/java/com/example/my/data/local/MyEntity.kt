package com.example.my.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_data_table")
data class MyEntity(
    @ColumnInfo(name = "article_title") val article_title:String,
    @ColumnInfo(name = "article_date") val article_date:String,
    @ColumnInfo(name = "article_description") val article_description:String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?= null
}
