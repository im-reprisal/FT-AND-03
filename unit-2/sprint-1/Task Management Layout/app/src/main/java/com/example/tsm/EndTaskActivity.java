package com.example.tsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndTaskActivity extends AppCompatActivity {
    private Button mbtnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_task);
        mbtnback=findViewById(R.id.btnback);
        mbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndTaskActivity.this,NewTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}