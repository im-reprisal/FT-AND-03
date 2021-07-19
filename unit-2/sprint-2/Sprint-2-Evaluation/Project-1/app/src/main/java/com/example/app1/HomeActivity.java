package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ResponseModel> responseModel = new ArrayList<>();
    private ResponseAdapter responseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        getList();
        setRecyclerData();
    }

    private void setRecyclerData() {
        responseAdapter = new ResponseAdapter((ArrayList<ResponseModel>) responseModel);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(responseAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void getList() {
        ApiService apiservice = Network.getInstance().create(ApiService.class);
        Call<List<ResponseModel>> call = apiservice.getUser();
        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                responseModel = response.body();
                responseAdapter.updateData(responseModel);

            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }
}