package com.example.livedata

class DataClass {
    var apiDataVersion = 0
    var dbDataVersion = 0
    fun getAPINewData(){
        apiDataVersion++
    }
    fun getDBNewData(){
        dbDataVersion++
    }
    fun  getApiData() : String{
        return "API Response ${apiDataVersion}"
    }
    fun  getDBData() : String{
        return "DB Data $dbDataVersion"
    }
}