package com.example.my.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(myEntity: MyEntity)

    @Query("select * from article_data_table")
    fun getItems(): LiveData<List<MyEntity>>
}