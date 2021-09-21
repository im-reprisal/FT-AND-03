package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_income.*

class IncomeFragment : Fragment(R.layout.fragment_income), onItemClick {
    private lateinit var dataAdapter: TaskAdapter
    private var dataList = mutableListOf<TaskModel>()

    private lateinit var roomDb : TaskRoomDataBase
    private lateinit var taskDAO: TaskDAO


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskDAO.getIncome().observe(viewLifecycleOwner, {
            val data = it
            val total_expense=0
            dataList.clear()
            dataList.addAll(data)
            Log.d("TAG", "onViewCreated: $total_expense")
            dataAdapter.notifyDataSetChanged()
        })

        dataAdapter = TaskAdapter(context as Activity,dataList,this)
        recyclerview_income.adapter = dataAdapter

    }
    override fun onEditClicked(dataModel: TaskModel) {


    }
    override fun onDeleteClicked(dataModel: TaskModel) {

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        roomDb = TaskRoomDataBase.getDataBaseObject(context)
        taskDAO = roomDb.getDataDAO()
    }
}