package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView mTvReceiveData;
    LocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTvReceiveData = findViewById(R.id.tvReceiveData);
        String[] permissions = {Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(MainActivity2.this, permissions,1);
        String data  = getIntent().getStringExtra("message");
        mTvReceiveData.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localReceiver);
    }
}