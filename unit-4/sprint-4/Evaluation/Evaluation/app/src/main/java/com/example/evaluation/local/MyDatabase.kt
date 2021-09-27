package com.example.evaluation.local

import androidx.room.Database

@Database(entities = [MyEntity::class],version = 1)
abstract class MyDatabase {
    abstract fun getMyDao(): MyDao
    companion object{
        private 
    }
}