package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mBtnFirst;
    Button mBtnSecond;
    Button mBtnThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnFirst = findViewById(R.id.btnFirst);
        mBtnSecond = findViewById(R.id.btnSecond);
        mBtnThird = findViewById(R.id.btnThird);
        mBtnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button One clicked", Toast.LENGTH_SHORT).show();
            }
        });
        mBtnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button second clicked", Toast.LENGTH_SHORT).show();
            }
        });
        mBtnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button Third clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}