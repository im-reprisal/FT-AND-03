package com.example.evaluation.views
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evaluation.R
import com.example.evaluation.Repository.PizzaRepository
import com.example.evaluation.adapter.PizzaAdapter
import com.example.evaluation.api.PizzaApiService
import com.example.evaluation.api.RetrofitHelper
import com.example.evaluation.interfaces.ItemListener
import com.example.evaluation.local.MyEntity
import com.example.evaluation.models.Crust
import com.example.evaluation.viewmodels.CartViewModel
import com.example.evaluation.viewmodels.CartViewModelFactory
import com.example.evaluation.viewmodels.PizzaViewModel
import com.example.evaluation.viewmodels.PizzaViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ItemListener{

    lateinit var pizzaViewModel: PizzaViewModel
    lateinit var pizzaAdapter: PizzaAdapter
    private val pizzaResponse = mutableListOf<Crust>()
    private lateinit var viewModel: CartViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pizzaAdapter = PizzaAdapter(pizzaResponse,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = pizzaAdapter

        val pizzaApiService = RetrofitHelper.getInstance().create(PizzaApiService::class.java)
        val repository = PizzaRepository(pizzaApiService)

        pizzaViewModel = ViewModelProvider(
            this,
            PizzaViewModelFactory(repository)
        ).get(PizzaViewModel::class.java)
        pizzaViewModel.pizzas.observe(this, Observer { it ->
            it.crusts.also {
                pizzaAdapter.pizzaList = it }

            pizzaAdapter.notifyDataSetChanged()
        })

        val appObj = application as CartApplication
        val cartRepository = appObj.repository
        val viewModelFactory = CartViewModelFactory(cartRepository)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CartViewModel::class.java)

    }

    override fun addCartItems(name: String, size: String, crust: String, price: Double) {
        val myEntity = MyEntity(name, size, crust, price)
        viewModel.addItems(myEntity)
    }
}
