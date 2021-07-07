package com.example.idenditycard;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
            if (i % 3 == 0)
                modelList.add(new Model(R.drawable.jeff_bezos, "Microsoft", 64,"Business"));
            else if (i % 3 == 1)
                modelList.add(new Model(R.drawable.bill_gates, "Amazon", 56,"Business"));
            else if (i % 3 == 2)
                modelList.add(new Model(R.drawable.prateek_sukla, "Masai School", 31,"Business"));
        }
    }

    private void setRecyclerAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ModelAdaptor modelAdaptor = new ModelAdaptor(modelList);
        recyclerView.setAdapter(modelAdaptor);
    }
}