package com.example.evaluation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evaluation.R
import com.example.evaluation.Repository.PizzaRepository
import com.example.evaluation.adapter.PizzaAdapter
import com.example.evaluation.api.PizzaApiService
import com.example.evaluation.api.RetrofitHelper
import com.example.evaluation.models.Crust
import com.example.evaluation.viewmodels.CartViewModel
import com.example.evaluation.viewmodels.PizzaViewModel
import com.example.evaluation.viewmodels.PizzaViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var pizzaViewModel: PizzaViewModel
    lateinit var pizzaAdapter: PizzaAdapter
    private val pizzaResponse = mutableListOf<Crust>()
    private lateinit var viewModel: CartViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pizzaAdapter = PizzaAdapter(pizzaResponse)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = pizzaAdapter

        val pizzaApiService = RetrofitHelper.getInstance().create(PizzaApiService::class.java)
        val repository = PizzaRepository(pizzaApiService)

        pizzaViewModel = ViewModelProvider(this,PizzaViewModelFactory(repository))
            .get(PizzaViewModel::class.java)
        pizzaViewModel.pizzas.observe(this, Observer {
            pizzaAdapter.
        })

    }
}