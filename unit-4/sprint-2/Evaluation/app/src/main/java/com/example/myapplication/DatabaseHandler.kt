package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class DatabaseHandler(private val context:Context):SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
    companion object{
        val DB_NAME = "mystore.db"
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
    fun insertItem(itm : Task) :Long{
        val db = writableDatabase
        val values = ContentValues()
        values.put(ITEM_NAME,itm.itemname)
        values.put(PRICE,itm.price)
        values.put(DESC,itm.desc)
        val success = db.insert(TABLE_NAME,null,values)
        db.close()
        return success
    }
    fun getAllItem() :MutableList<Task> {
        val taskList: ArrayList<Task> = ArrayList()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
//        val cursor = db.rawQuery(query,null)
//        if (cursor != null && cursor.count > 0){
//            cursor.moveToFirst()
//        }
        val cursor: Cursor?
        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(query)
            return ArrayList()
        }
        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getInt(cursor.getColumnIndex(ID))
                var price = cursor.getString(cursor.getColumnIndex(PRICE))
                var itemname = cursor.getString(cursor.getColumnIndex(ITEM_NAME))
                var desc = cursor.getString(cursor.getColumnIndex(DESC))

//                val task = Task()
//                task.id = id
//                task.price = price
//                task.itemname = itemname
//                task.desc = desc

                val itm = Task(itemname = itemname ,price = price , desc = desc)

                taskList.add(itm)
            } while (cursor.moveToNext())
        }
        return taskList
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}