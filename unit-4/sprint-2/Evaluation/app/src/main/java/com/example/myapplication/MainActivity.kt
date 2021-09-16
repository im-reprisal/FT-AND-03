package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_item.*
import kotlinx.android.synthetic.main.fragment_search_item.*

class MainActivity : AppCompatActivity() {
    private lateinit var adaptor: ItemAdapter
    private val addModel = listOf<Task>()
    private var tasksList = mutableListOf<Task>()
    private val dataBaseHandler = DataBaseHandler(this)
    private val liveDataClass = LiveDataClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        btnSave.setOnClickListener {
            dataBaseHandler?.insertItem(etItemName.text.toString(),
                etPrice.text.toString().toInt(),
                etDesc.text.toString())
        }
        btnSearch.setOnClickListener {
            liveDataClass.incSearchCount()
            tasksList.clear()
            tasksList.addAll(dataBaseHandler.getSearchTask(etSearch.text.toString()))
            adaptor.notifyDataSetChanged()
        }
       liveDataClass.getMediatorLiveData().observe(this, Observer {
            tvCountSearch.text = it
       })
    }
    fun initRecyclerView(){
        val LayoutManager = LinearLayoutManager(this)
        adaptor = ItemAdapter(addModel, tasksList)
        recyclerView.adapter = adaptor
        recyclerView.layoutManager = LayoutManager
    }
}