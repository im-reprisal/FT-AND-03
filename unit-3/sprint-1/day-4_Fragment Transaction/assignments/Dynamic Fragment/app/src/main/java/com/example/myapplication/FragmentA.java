package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentA extends Fragment {
    private Button mBtnGetData;
    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> responseModelArrayList = new ArrayList<>();
    private ResponseAdapter responseAdapter;

    public FragmentA() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViews(view);
    }

    private void iniViews(View view) {
        mBtnGetData = view.findViewById(R.id.btnGetData);
        recyclerView = view.findViewById(R.id.recyclerview);
        mBtnGetData.setOnClickListener(v -> {
            showData();
            setRecyclerData();
        });
    }
    private void setRecyclerData() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseModel>> call = apiService.data("shivarajp",
                "2cbe00030c04472c9d8ad4b0ec112dbe",
                "raw", "c651391e428182f08d60d59e79073f3fcf79b858", "nobroker");
        call.enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                responseModelArrayList = response.body();
                responseAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void showData() {
        responseAdapter = new ResponseAdapter(responseModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(responseAdapter);
    }
}