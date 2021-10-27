package com.masai.sprint_1unit_5.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(model: MyEntity)

    @Query("select * from actors")
    fun getDataFromDB(): LiveData<List<MyEntity>>

    @Query("delete from actors")
    fun deleteAll()
}