package com.masai.sprint_1unit_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.sprint_1unit_5.data.Repository.Repository
import com.masai.sprint_1unit_5.data.local.MyDao
import com.masai.sprint_1unit_5.data.local.MyEntity
import com.masai.sprint_1unit_5.data.local.MyRoomDataBase
import com.masai.sprint_1unit_5.ui.adapter.ItemAdapter
import com.masai.sprint_1unit_5.ui.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var list = arrayListOf<MyEntity>()
    lateinit var itemAdapter: ItemAdapter

    lateinit var roomDataBase: MyRoomDataBase
    lateinit var itemDao: MyDao
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDataBase = MyRoomDataBase.databaseObject(this)
        itemDao = roomDataBase.getDao()

        val repository = Repository(itemDao)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ViewModell::class.java)

        fetchData.setOnClickListener {
            viewModel.deleteAllData()
            viewModel.insertData(numberPage.text.toString().toInt())
        }

        viewModel.getAllData().observe(this, Observer {
            list.clear()
            list.addAll(it)
            itemAdapter.notifyDataSetChanged()
        })
        setRecyclerView()
    }

    private fun setRecyclerView() {
        itemAdapter = ItemAdapter(list)
        var linearLayoutManager = LinearLayoutManager(this)

        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = linearLayoutManager
    }
}