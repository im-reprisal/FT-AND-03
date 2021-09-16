package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_income.*
import java.lang.Exception

class IncomeFragment : Fragment(), onItemClick {
    private lateinit var dataAdapter: DataAdapter
    private var mutableList = mutableListOf<DataModel>()
    private var dbHandler : DatabaseHandler? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dbHandler = DatabaseHandler(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_income, container, false)
    }
    override fun onResume() {
        super.onResume()
        updateUI()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            mutableList = dbHandler?.getIncomeData()!!
        }catch (e: Exception){
            Toast.makeText(activity, "Data is not Available", Toast.LENGTH_SHORT).show()
        }
        setRecyclerview()
    }
    private fun setRecyclerview() {
<<<<<<< HEAD
=======

>>>>>>> origin/main
        dataAdapter = DataAdapter(context as Activity,mutableList,this)
        recyclerview_income.adapter = dataAdapter
    }
    private fun updateUI(){
<<<<<<< HEAD
        val  newData = dbHandler?.getIncomeData()
        mutableList.clear()
        newData?.let { mutableList.addAll(it) }
=======
        val  latestData = dbHandler?.getIncomeData()
        mutableList.clear()
        latestData?.let { mutableList.addAll(it) }
>>>>>>> origin/main
        dataAdapter.notifyDataSetChanged()
    }

    override fun onEditClicked(dataModel: DataModel) {

        dbHandler?.editIncome(dataModel)
        updateUI()
    }
    override fun onDeleteClicked(dataModel: DataModel) {
        dbHandler?.deleteIncome(dataModel)
        updateUI()
    }
}