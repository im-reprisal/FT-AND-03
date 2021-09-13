package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sqliteHelper : DatabaseHandler
    private lateinit var recyclerView : RecyclerView
    private var adapter : ItemAdapter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        initRecyclerView()
        sqliteHelper = DatabaseHandler(this)
        btnSave.setOnClickListener {
            addItem()
        }
        btnGetItem.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
       val taskList = sqliteHelper.getAllItem()
        adapter?.addItems(taskList as ArrayList<Task>)
    }

    private fun addItem() {
       val itemname = etItemName.text.toString()
        val price = etPrice.text.toString()
        val desc = etDesc.text.toString()
        val itm = Task(itemname = itemname , price = price , desc = desc)
        sqliteHelper.insertItem(itm)
    }
    fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}