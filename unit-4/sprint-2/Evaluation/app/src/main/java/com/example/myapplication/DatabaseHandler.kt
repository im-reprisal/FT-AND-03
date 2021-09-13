package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(private val context:Context):SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
    companion object{
        val DB_NAME = "MyStore"
        val DB_VERSION = 1
        val TABLE_NAME = "store"
        val ID = "id"
        val ITEM_NAME = "itemName"
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

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}