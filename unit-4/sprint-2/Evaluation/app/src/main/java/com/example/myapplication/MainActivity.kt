package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_add_item.*
import kotlinx.android.synthetic.main.fragment_search_item.*

class MainActivity : AppCompatActivity() {
//    private var tasksList = mutableListOf<Task>()
//    private val itemModel = listOf<Task>()
//    private val dataBaseHandler = DataBaseHandler(this)
//    private lateinit var adapter: ItemAdapter
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        initRecyclerView()
//        btnSave.setOnClickListener {
//            addItem()
//        }
//        btnGetItem.setOnClickListener {
//            getData()
//        }
//    }
//
//    private fun getData() {
//        tasksList.clear()
//        tasksList.addAll(dataBaseHandler.getAllItems())
////        liveData.getData(tasksList.size)
//        adapter.notifyDataSetChanged()
//    }
//
//    private fun addItem() {
//        dataBaseHandler?.insertItem(
//            etItemName.text.toString(),
//            etPrice.text.toString().toInt(),
//            etDesc.text.toString())
//    }
//    fun initRecyclerView(){
//        val LayoutManager = LinearLayoutManager(this)
//        adapter = ItemAdapter(itemModel,tasksList)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LayoutManager
//    }

    private lateinit var adaptor: ItemAdapter
    private val addModel = listOf<Task>()
    private var tasksList = mutableListOf<Task>()
    private val dataBaseHandler = DataBaseHandler(this)
//    private val liveData = LiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {
            dataBaseHandler?.insertItem(etItemName.text.toString(),
                etPrice.text.toString().toInt(),
                etDesc.text.toString())
        }

        btntoSearch.setOnClickListener {
            tasksList.clear()
            tasksList.addAll(dataBaseHandler.getSearchTask(ettoSearch.text.toString()))
   //         liveData.getData(tasksList.size)
            adaptor.notifyDataSetChanged()

        }


//        liveData.getcountData().observe(this, Observer {
//            tvCount.text = it
//        })
        val LayoutManager = LinearLayoutManager(this)
        adaptor = ItemAdapter(addModel, tasksList)
        RecyclerViewSearch.adapter = adaptor
        RecyclerViewSearch.layoutManager = LayoutManager
    }
}