package com.masai.sprint_1unit_5.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_of_actors_table")
data class MyEntity(
    @ColumnInfo(name = "name")
    var name :String,
    @ColumnInfo(name = "birthday")
    var birthDay:String,
    @ColumnInfo(name = "deathday")
    var deathday:String,
    @ColumnInfo(name = "imageURl")
    var imageUrl:String,
    @ColumnInfo(name = "country name")
    var countryName:String,
    @ColumnInfo(name = "country code")
    var countryCode:String,
    @ColumnInfo(name = "country time-zone")
    var timeZone:String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int?=null
}
