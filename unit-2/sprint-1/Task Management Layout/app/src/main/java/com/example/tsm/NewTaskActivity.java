package com.example.tsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewTaskActivity extends AppCompatActivity {
    private Button mbtnaddnewtask;
    private Button mbtnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        intidviews();
        mbtnaddnewtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(NewTaskActivity.this,EndTaskActivity.class);
                startActivity(intent);
            }
        });
        mbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewTaskActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void intidviews() {
        mbtnback=findViewById(R.id.btnback);
        mbtnaddnewtask=findViewById(R.id.btnaddnewtask);
    }
}