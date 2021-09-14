package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_expense.*

class ExpenseFragment : Fragment(), onItemClick{
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
        return inflater.inflate(R.layout.fragment_expense, container, false)
    }
    override fun onResume() {
        super.onResume()
        updateUI()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mutableList = dbHandler?.getExpenseData()!!
        setRecyclerview()
    }
    private fun setRecyclerview() {
        dataAdapter = DataAdapter(context as Activity,mutableList,this)
        recyclerview_expense.adapter = dataAdapter
    }
    private fun updateUI(){
        val  latestData = dbHandler?.getExpenseData()
        mutableList.clear()
        latestData?.let { mutableList.addAll(it) }
        dataAdapter.notifyDataSetChanged()
    }
    override fun onEditClicked(dataModel: DataModel) {
        dbHandler?.editExpense(dataModel)
        updateUI()
    }
    override fun onDeleteClicked(dataModel: DataModel) {
        dbHandler?.deleteExpense(dataModel)
        updateUI()
    }
}