package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mBtnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnClick = findViewById(R.id.btnClick);
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent();
                mintent.setAction(Intent.ACTION_VIEW);
                mintent.setData(Uri.parse("https://www.masaischool.com/"));
                Toast.makeText(MainActivity.this, "Found", Toast.LENGTH_SHORT).show();

                if (mintent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mintent);
                } else {
                    Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}