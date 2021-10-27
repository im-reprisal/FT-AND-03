package com.masai.sprint_1unit_5.data.Repository

import androidx.lifecycle.LiveData
import com.masai.sprint_1unit_5.data.local.MyDao
import com.masai.sprint_1unit_5.data.local.MyEntity
import com.masai.sprint_1unit_5.data.models.ResponseModel
import com.masai.sprint_1unit_5.network.ApiClient
import com.masai.sprint_1unit_5.network.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (var myDao: MyDao){

    fun insertData1(num:Int){
        var api = Network.getRetrofit().create(ApiClient::class.java)
        api.getApiData(num).enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.body()!=null){
                    CoroutineScope(Dispatchers.IO).launch {

                        response.body()?.forEach {

                            var name = "0"
                            if (it.name != null) name = it.name

                            var birth = "0"
                            if (it.birthday != null) birth = it.birthday

                            var death = "0"
                            if (it.deathday != null) death = it.deathday

                            var imageur = "0"
                            if (it.image != null) imageur = it.image.original

                            var cname = "0"
                            if (it.country != null) cname = it.country.name

                            var ccode = "0"
                            if (it.country != null) ccode = it.country.code

                            var time = "0"
                            if (it.country != null) time = it.country.timezone

                            var response = MyEntity(name, birth, death, imageur, cname, ccode, time)
                            myDao.insertData(response)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }

        })
    }

    fun deleteAll(){
        CoroutineScope(Dispatchers.IO).launch {
            myDao.deleteAll()
        }
    }
    fun getData():LiveData<List<MyEntity>>{
        return  myDao.getDataFromDB()
    }
}