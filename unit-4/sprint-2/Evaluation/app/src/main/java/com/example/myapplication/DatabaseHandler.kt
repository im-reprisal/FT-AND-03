package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(private val context:Context):SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
    companion object{
        val DB_NAME = "MyStore"
        val DB_VERSION = 1
        val TABLE_NAME = "store"
        val ID = "id"
        val ITEM_NAME = "itemname"
        val PRICE = "price"
        val DESC = "desc"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = "CREATE TABLE " +
                "$TABLE_NAME(" +
                "$ID INTEGER PRIMARY KEY," +
                "$ITEM_NAME TEXT, "+
                "$PRICE INTEGER, " +
                "$DESC TEXT)"
        db?.execSQL(CREATE_TABLE_QUERY)
    }
    fun insertTask(itemname:String,price:Int,desc:String){
        val db = writableDatabase
        val values = ContentValues()
        values.put(ITEM_NAME,itemname)
        values.put(PRICE,price)
        values.put(DESC,desc)
        val idValue = db.insert(TABLE_NAME,null,values)
    }
    fun getAllTask() :MutableList<Task>{
        val taskList = mutableListOf<Task>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
        val cursor = db.rawQuery(query,null)
        if (cursor != null && cursor.count > 0){
            cursor.moveToFirst()
        }
        do {
            val id = cursor.getInt(cursor.getColumnIndex(ID))
            val price = cursor.getInt(cursor.getColumnIndex(PRICE))
            val itemname = cursor.getString(cursor.getColumnIndex(ITEM_NAME))
            val desc = cursor.getString(cursor.getColumnIndex(DESC))

            val task = Task()
            task.id = id
            task.price = price
            task.itemname = itemname
            task.desc= desc

            taskList.add(task)
        } while (cursor.moveToNext())
        return taskList
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}