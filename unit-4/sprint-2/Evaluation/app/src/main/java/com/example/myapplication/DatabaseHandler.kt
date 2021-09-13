package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataBaseHandler(val context: Context) :
    SQLiteOpenHelper(context, "addTask", null, 1) {

    companion object {
        val DB_NAME = "ItemDB"
        val DB_VERSION = 1
        val TABLE_NAME = "item"
        val ID = "id"
        val ITEM_NAME = "itemname"
        val PRICE = "price"
        val DESC = "desc"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = "CREATE TABLE " +
                "$TABLE_NAME(" +
                "$ID INTEGER PRIMARY KEY ," +
                "$ITEM_NAME TEXT ," +
                "$DESC TEXT ," +
                "$PRICE INTEGER )"

        db?.execSQL(CREATE_TABLE_QUERY)

    }

    fun insertItem(itemName: String,price: Int, desc: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(ITEM_NAME, itemName)
        values.put(PRICE, price)
        values.put(DESC, desc)

        val success = db.insert(TABLE_NAME, null, values)
        if (success.toInt() == -1) {
            Toast.makeText(context, "Failed to Add the Item ", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Success to Add the Item ", Toast.LENGTH_SHORT).show()

        }
    }

    fun getAllItems(): MutableList<Task> {
        val taskList = mutableListOf<Task>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
        val cursor = db.rawQuery(query, null)
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()


            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val name = cursor.getString(cursor.getColumnIndex(ITEM_NAME))
                val price = cursor.getInt(cursor.getColumnIndex(PRICE))
                val desc = cursor.getString(cursor.getColumnIndex(DESC))
                val itm = Task()
                itm.id = id
                itm.desc = desc
                itm.itemname = name
                itm.price = price

                taskList.add(itm)
            } while (cursor.moveToNext())
        }
        return taskList
    }


//    fun getSearchTask(title : String): MutableList<Task> {
//        val tasklist = mutableListOf<Task>()
//        val db = readableDatabase
//        val query = "select * from $TABLE_NAME where $ITEM_NAME like '$title'"
//        val cursor = db.rawQuery(query, null)
//        if (cursor != null && cursor.count > 0) {
//            cursor.moveToFirst()
//
//
//            do {
//                val id = cursor.getInt(cursor.getColumnIndex(ID))
//                val item = cursor.getString(cursor.getColumnIndex(ITEM_NAME))
//                val desc = cursor.getString(cursor.getColumnIndex(DESCRIPTION))
//                val itemprice = cursor.getInt(cursor.getColumnIndex(PRICE))
//
//                val addModel = Task()
//                addModel.id = id
//                addModel.addDescription = desc
//                addModel.addItemName = item
//                addModel.addPrice = itemprice
//
//                tasklist.add(addModel)
//            } while (cursor.moveToNext())
//        }
//        return tasklist
//    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}