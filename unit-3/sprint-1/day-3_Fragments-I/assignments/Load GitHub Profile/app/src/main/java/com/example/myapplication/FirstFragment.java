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
import android.widget.EditText;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {
    private Button mBtnSearch;
    private EditText mEtSearch;
    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> responseModelArrayList = new ArrayList<>();
    private GitHubAdapter gitHubAdapter;
    public FirstFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnSearch = view.findViewById(R.id.btnGetData);
        mEtSearch = view.findViewById(R.id.etSearch);
        recyclerView = view.findViewById(R.id.recyclerView);
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecycleView();
                showData();
            }
        });
    }
    private void showData() {
        gitHubAdapter = new GitHubAdapter(responseModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(gitHubAdapter);
    }
    private void setRecycleView() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseModel>> call = apiService.getData(mEtSearch.getText().toString());
        call.enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    responseModelArrayList = response.body();
                    gitHubAdapter.updateData(responseModelArrayList);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {

            }
        });
    }
}