package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

class ExpenseFragment : Fragment(R.layout.fragment_expense), onItemClick{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onEditClicked(dataModel: TaskModel) {

    }
    override fun onDeleteClicked(dataModel: TaskModel) {

    }
}