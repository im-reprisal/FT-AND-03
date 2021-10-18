package com.masai.sprint_2.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_data_table")
data class MyEntity(
    @ColumnInfo(name = "person_name") val person_name:String,
    @ColumnInfo(name = "country_name") val country_name:String,
    @ColumnInfo(name = "birth_date") val birth_date:String,
    @ColumnInfo(name = "death_date") val death_date:String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?= null
}
