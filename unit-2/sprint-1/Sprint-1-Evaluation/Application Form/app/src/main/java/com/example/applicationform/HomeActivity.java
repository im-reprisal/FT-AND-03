package com.example.applicationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvName = findViewById(R.id.tvName);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        mTvName.setText(userName);
    }
}