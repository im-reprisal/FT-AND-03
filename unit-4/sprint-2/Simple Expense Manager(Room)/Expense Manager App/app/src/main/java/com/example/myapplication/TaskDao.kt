package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addData(dataModel: TaskModel)

    @Query("select * from records where category = 'Income' ")
    fun getIncome() : LiveData<List<TaskModel>>

    @Query("select * from records where category = 'Expense' ")
    fun getExpense() : LiveData<List<TaskModel>>

    @Update
    fun updateData(dataModel: TaskModel)

    @Delete
    fun deleteData(dataModel: TaskModel)

}