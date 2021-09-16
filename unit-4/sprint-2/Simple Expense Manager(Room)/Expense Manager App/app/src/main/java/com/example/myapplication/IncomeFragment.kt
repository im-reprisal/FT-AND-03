package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

class IncomeFragment : Fragment(R.layout.fragment_income), onItemClick {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onEditClicked(dataModel: TaskModel) {


    }
    override fun onDeleteClicked(dataModel: TaskModel) {

    }
}