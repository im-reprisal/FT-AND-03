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
public class FragmentB extends Fragment {
    private RecyclerView recyclerview;
    private ModelAdapter adapter;
    private List<Model> modelList = new ArrayList<>();
    public FragmentB() {
        // Required empty public constructor
    }
    public static FragmentB newInstance() {
        FragmentB fragment = new FragmentB();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview = view.findViewById(R.id.recyclerview);
        setRecyclerView();
        buildData();
    }
    private void buildData() {
        for (int i = 0 ; i < 15 ; i++){
            if (i % 5 == 0)
                modelList.add(new Model("Banglore"));
            if (i % 5 == 1)
                modelList.add(new Model("Delhi"));
            if (i % 5 == 2)
                modelList.add(new Model("Karnatka"));
            if (i % 5 == 3)
                modelList.add(new Model("Chennai"));
            if (i % 5 == 4)
                modelList.add(new Model("Bihar"));
        }
    }
    private void setRecyclerView(){
        adapter = new ModelAdapter(modelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
    }
}