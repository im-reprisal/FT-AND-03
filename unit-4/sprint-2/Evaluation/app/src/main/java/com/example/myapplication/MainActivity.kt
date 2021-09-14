package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_add_item.*
import kotlinx.android.synthetic.main.fragment_search_item.*

class MainActivity : AppCompatActivity() {
    private lateinit var adaptor: ItemAdapter
    private val addModel = listOf<Task>()
    private var tasksList = mutableListOf<Task>()
    private val dataBaseHandler = DataBaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        btnSave.setOnClickListener {
            dataBaseHandler?.insertItem(etItemName.text.toString(),
                etPrice.text.toString().toInt(),
                etDesc.text.toString())
        }
        btnSearch.setOnClickListener {
            tasksList.clear()
            tasksList.addAll(dataBaseHandler.getSearchTask(etSearch.text.toString()))
            adaptor.notifyDataSetChanged()
        }
    }
    fun initRecycler(){
        val LayoutManager = LinearLayoutManager(this)
        adaptor = ItemAdapter(addModel, tasksList)
        recyclerView.adapter = adaptor
        recyclerView.layoutManager = LayoutManager
    }
}