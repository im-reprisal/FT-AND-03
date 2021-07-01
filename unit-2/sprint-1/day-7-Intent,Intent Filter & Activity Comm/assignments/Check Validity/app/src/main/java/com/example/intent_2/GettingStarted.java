package com.example.intent_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GettingStarted extends AppCompatActivity {
    Button mBtnGetStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);
        mBtnGetStart.findViewById(R.id.btnGetStarted);
        mBtnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GettingStarted.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}