package com.example.animal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  ItemClickListener{

    private RecyclerView mRecyclerView;
    private ArrayList<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rvRecyclerView);
        buildData();
        setRecyclerAdapter();
    }

    private void buildData() {
        modelList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                modelList.add(new Model(R.drawable.crow,"Crow"));
            if (i % 2 == 1)
                modelList.add(new Model(R.drawable.owl,"Owl"));
            if (i % 2 == 0)
                modelList.add(new Model(R.drawable.peacock,"Peacock"));
            if (i % 2 == 1)
                modelList.add(new Model(R.drawable.piegon,"Piegon"));

        }
    }
    private void setRecyclerAdapter(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        ModelAdaptor modelAdaptor = new ModelAdaptor(modelList,this);
        mRecyclerView.setAdapter(modelAdaptor);
    }

    @Override
    public void onItemClicked(Model model) {
        Toast .makeText(this,model.getName(),Toast.LENGTH_SHORT).show();
    }
}