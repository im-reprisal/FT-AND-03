package com.example.viewpagerwithtabs;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
public class FragmentA extends Fragment {
    private RecyclerView recyclerview;
    private ModelAdapter adapter;
    private List<Model> modelList = new ArrayList<>();
    public FragmentA() {
        // Required empty public constructor
    }
    public static FragmentA newInstance() {
        FragmentA fragment = new FragmentA();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview = view.findViewById(R.id.recyclerview);
        setRecyclerView();
        buildData();
    }
    private void buildData() {
        for (int i = 0 ; i < 15 ; i++){
            if (i % 5 == 0)
                modelList.add(new Model("Llyod Dcosta"));
            if (i % 5 == 1)
                modelList.add(new Model("Nrupul Dev"));
            if (i % 5 == 2)
                modelList.add(new Model("Yogesh Bhat"));
            if (i % 5 == 3)
                modelList.add(new Model("Sai Krishna"));
            if (i % 5 == 4)
                modelList.add(new Model("Nishant Rishab"));
        }
    }
    private void setRecyclerView(){
        adapter = new ModelAdapter(modelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
    }
}