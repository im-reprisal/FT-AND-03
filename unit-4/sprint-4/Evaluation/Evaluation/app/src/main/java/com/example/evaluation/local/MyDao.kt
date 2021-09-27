package com.example.evaluation.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.selects.select

interface MyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItems(myEntity: MyEntity)

    @Query("select * from my_cart_table")
    fun getItems():LiveData<List<MyEntity>>
}