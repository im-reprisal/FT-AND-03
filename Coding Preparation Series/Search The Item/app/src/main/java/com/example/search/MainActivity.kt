package com.example.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.search.api.CityAdaptor
import com.example.search.data.Address
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var cityViewModel: CityViewModel
    private var list = emptyList<Address>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        cityViewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
        search()
    }

    private fun search() {
        et_Search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loadapi(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }

    private fun loadapi(query: String) {
        cityViewModel.liveData.observe(this, {
            it.let {
                when (it) {
                    is MainUiModel.OnSuccess -> {
                            list = it.responseDTO.data.addressList as ArrayList<Address>
                            val adaptor = CityAdaptor(list)
                            val layoutManager = LinearLayoutManager(this)
                            recyclerView.adapter = adaptor
                            recyclerView.layoutManager = layoutManager
                        }

                    is MainUiModel.OnFailure ->{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        cityViewModel.getData(query)
    }
}