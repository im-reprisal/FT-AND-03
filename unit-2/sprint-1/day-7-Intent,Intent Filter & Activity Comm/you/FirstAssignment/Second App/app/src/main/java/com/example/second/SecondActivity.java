package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if(getIntent() != null && getIntent().getExtras() !=null){
            String data = getIntent().getStringExtra("username");
            Toast.makeText(SecondActivity.this," " + data,Toast.LENGTH_SHORT).show();
        }
    }
}