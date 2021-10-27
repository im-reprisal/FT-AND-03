package com.masai.sprint_1unit_5.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyEntity::class],version = 1)
abstract class MyRoomDataBase: RoomDatabase() {

    abstract fun getDao():MyDao
    companion object{
        private var INSTANCE : MyRoomDataBase?=null
        fun databaseObject(context: Context):MyRoomDataBase{
            if(INSTANCE==null){
                val obj = Room.databaseBuilder(
                    context.applicationContext,
                    MyRoomDataBase::class.java,
                    "actors_room_database"
                )

                obj.fallbackToDestructiveMigration()
                INSTANCE = obj.build()
                return INSTANCE!!
            }
            else return INSTANCE!!
        }
    }
}