package com.example.intent_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private TextView mtvEmailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
        getDataFromIntent();
    }
    private void initializeViews(){
        mtvEmailId = findViewById(R.id.tvEmailId);
    }
    private void getDataFromIntent(){
        if (getIntent() != null && getIntent().getExtras() != null){
            String data = getIntent().getStringExtra("data");
            mtvEmailId.setText(data);
        }
    }
}