package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var contentList: List<ResponseModelItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {

            val res: String = async {
                var data = getData()
                return@async "$data"
            }.await()

            CoroutineScope(Dispatchers.Main).launch {
                Log.d("onCreate", "onCreate: $res")
            }
        }
    }
    fun getData(): String {
        val apiService = Network.getInstance().create(ApiService::class.java)
        apiService.getUserData().enqueue(object : Callback<ResponseModel> {
            override fun onResponse(
                call: Call<ResponseModel>,
                response: Response<ResponseModel>
            ) {
                response.body()?.run {
                    contentList = response.body()!!
                    tvContent.text = response.body()?.get(0)?.name.toString()
                }
            }
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }
        })
       return ""
    }
}