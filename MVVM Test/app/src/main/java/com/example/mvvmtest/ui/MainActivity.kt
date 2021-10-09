package com.example.mvvmtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmtest.MainUIModel
import com.example.mvvmtest.R
import com.example.mvvmtest.data.models.ResultsDTO
import com.example.mvvmtest.ui.adapter.MainAdapter
import com.example.mvvmtest.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private var list = emptyList<ResultsDTO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.callApi()
        mainViewModel.liveData.observe(this, {

            it.let {
                when (it) {
                    is MainUIModel.OnSuccess -> {
                        list = it.responseDTO.results as ArrayList<ResultsDTO>
                        setRecyclerAdapter()
                    }

                    is MainUIModel.onFailure -> {
                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }

    fun setRecyclerAdapter() {
        val mainAdapter = MainAdapter(list)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.apply {
            adapter = mainAdapter
            layoutManager = linearLayoutManager
        }
    }
}