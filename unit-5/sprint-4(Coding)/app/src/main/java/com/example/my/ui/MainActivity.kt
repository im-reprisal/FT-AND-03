package com.example.my.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my.R
import com.example.my.data.models.Article
import com.example.my.ui.adapter.MainAdapter
import com.example.my.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel : MainViewModel
    private lateinit var mainAdapter: MainAdapter
    var list = ArrayList<Article>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setRecyclerAdapter()
        mainViewModel.callAPI()

        mainViewModel.liveData.observe(this,{
            list.clear()
            list.addAll(it)
            mainAdapter.notifyDataSetChanged()
        })
    }

    private fun setRecyclerAdapter() {
        mainAdapter = MainAdapter(list)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            adapter = mainAdapter
            layoutManager = linearLayoutManager
        }
    }
}