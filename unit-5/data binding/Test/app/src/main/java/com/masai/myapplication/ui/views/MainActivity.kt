package com.masai.myapplication.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.myapplication.R
import com.masai.myapplication.data.models.ResultDTO
import com.masai.myapplication.ui.adapter.MainAdapter
import com.masai.myapplication.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    var list = ArrayList<ResultDTO>()
lateinit var mainAdapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setRecyclerAdapter()
        mainViewModel.callAPi()

        mainViewModel.liveData.observe(this,{
            list.clear()
            list.addAll(it)
            mainAdapter.notifyDataSetChanged()
        })
    }
    fun setRecyclerAdapter() {
         mainAdapter = MainAdapter(list)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            adapter = mainAdapter
            layoutManager = linearLayoutManager
        }
    }
}