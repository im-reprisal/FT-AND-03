package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        buildList();
        setRecyclerView();
    }

    private void buildList() {
        studentList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0)
            studentList.add(new Student("Nishant", 24, ""+(i+1)));
            if (i % 2 == 1)
                studentList.add(new Student("Rishab", 24, ""+(i+1)));
         }
    }
    private void setRecyclerView(){
        StudentAdapter adapter = new StudentAdapter(studentList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}