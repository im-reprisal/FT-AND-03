package com.masai.sprint_2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.sprint_2.R
import com.masai.sprint_2.ui.adapter.MainAdapter
import com.masai.sprint_2.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel:MainViewModel
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setAdapter()
        mainViewModel.searchPeopleList().observe(
            this,{
                it?.let {
                    CoroutineScope(Main).launch {
                        mainAdapter.submitData(it)
                    }
                }
            }
        )
    }

    private fun setAdapter() {
        mainAdapter = MainAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            this.adapter = mainAdapter
        }
    }
}