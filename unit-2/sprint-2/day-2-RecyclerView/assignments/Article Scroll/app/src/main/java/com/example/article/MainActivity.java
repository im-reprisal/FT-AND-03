package com.example.article;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    private RecyclerView recyclerView;
    private ArrayList<Model> modelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvRecyclerView);
        buildData();
        setRecyclerAdapter();
    }
    private void buildData() {
        modelList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                modelList.add(new Model(R.drawable.th_1,"Blue Ocean Wave Crashed","As waves crashed against the shoreline in Encinitas on Monday, a bright blue hue overtook the ocean thanks to the return of an unpredictable natural phenomenon.The bright blue light, created by phytoplankton through a process called bioluminescence.","Mark"));
            else if (i % 2 == 1)
                modelList.add(new Model(R.drawable.th_1,"Blue Ocean Wave Crashed","As waves crashed against the shoreline in Encinitas on Monday, a bright blue hue overtook the ocean thanks to the return of an unpredictable natural phenomenon.The bright blue light, created by phytoplankton through a process called bioluminescence.","Mark"));
        }
    }
    private void setRecyclerAdapter(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ModelAdaptor modelAdaptor = new ModelAdaptor(modelList,this);
        recyclerView.setAdapter(modelAdaptor);
    }

    @Override
    public void onItemClicked(Model model) {
        Toast.makeText(this,model.getAuthor(),Toast.LENGTH_SHORT).show();
    }
}