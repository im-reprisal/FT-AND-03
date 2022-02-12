package com.example.TastyApp.UI

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.TastyApp.UI.adapter.HomeFragmentAdapter
import com.example.TastyApp.DATA.model.ItemX
import com.example.TastyApp.DATA.model.Result
import com.example.TastyApp.DATA.repository.FoodRepository
import com.example.TastyApp.R
import com.example.TastyApp.INTERFACE.OnClickListener
import com.example.TastyApp.UI.viewmodel.MainViewModel
import com.example.TastyApp.UI.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), OnClickListener {
    lateinit var repo: FoodRepository
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        repo = FoodRepository()
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(MainViewModel::class.java)

        viewModel.getData().observe(requireActivity(), Observer {
            val list =
                it as ArrayList<Result>
            setRecyclerView(list)
        })
    }

    private fun setRecyclerView(list: ArrayList<Result>) {
        mainRecyclerview.adapter = HomeFragmentAdapter(list, this)
        mainRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }
    override fun onClick(itemX: ItemX) {
        val intent = Intent(context, FoodDetailActivity::class.java)
        intent.putExtra("foodName", itemX.id)
        startActivity(intent)
    }
}