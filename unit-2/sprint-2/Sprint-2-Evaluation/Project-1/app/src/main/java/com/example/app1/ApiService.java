package com.example.app1;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiService {
   @GET("v1/us/daily.json")
    Call<ResponseModel> getData(@Body ResponseModel responseModel);
}
