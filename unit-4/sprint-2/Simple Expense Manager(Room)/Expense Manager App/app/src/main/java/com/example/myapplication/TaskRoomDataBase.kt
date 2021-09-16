package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TaskModel::class],version = 1)
abstract class TaskRoomDataBase: RoomDatabase() {

    abstract fun getDataDAO() : DataDAO

    companion object{

        private var INSTANCE : TaskRoomDataBase? = null

        fun getDataBaseObject(context: Context) : TaskRoomDataBase{
            if (INSTANCE== null){
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    TaskRoomDataBase::class.java,
                    "data_db"
                )

                INSTANCE = builder.build()
                return INSTANCE as TaskRoomDataBase
            }
            else return INSTANCE as TaskRoomDataBase
        }
    }
}