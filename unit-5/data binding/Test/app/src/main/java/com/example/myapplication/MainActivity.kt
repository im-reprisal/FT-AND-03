package com.example.myapplication

import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Network.Companion.getRetrofitInstance
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var popularMoviesAdapter: PopularMoviesAdapter

    private var responseList = listOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        callAPI()
        setRecycler()
    }
    private fun setRecycler() {
        activityMainBinding.apply {
            popularMoviesAdapter = PopularMoviesAdapter(responseList)
            rvPopularMovies.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPopularMovies.adapter = popularMoviesAdapter
        }
    }

    private fun callAPI() {
        val apiClient = Network.getRetrofitInstance.create(APIClient::class.java)
            apiClient.getAPIResponse().enqueue(object : Callback<List<Result>> {
                override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
                    responseList = response.body()!!
                }
                override fun onFailure(call: Call<List<Result>>, t: Throwable) {

                }
            })
    }
}