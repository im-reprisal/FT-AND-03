package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.progressindicator.CircularProgressIndicator;
public class MainActivity extends AppCompatActivity {
    private CircularProgressIndicator progressbar;
    private TextView mTvPercentage,mTvText;
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    int progress = (int) msg.obj;
                    progressbar.setProgress(progress);
                    mTvPercentage.setVisibility(View.VISIBLE);
                    mTvText.setText(progress+" % loading");
                    break;
                case 2:
                    String message = (String) msg.obj;
                    progressbar.setVisibility(View.GONE);
                    mTvPercentage.setVisibility(View.INVISIBLE);
                    mTvText.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressbar = findViewById(R.id.progressbar);
        mTvPercentage = findViewById(R.id.tvPercentage);
        mTvText = findViewById(R.id.tvText);
        WorkerThread workerThread = new WorkerThread("async", mainThreadHandler);
        workerThread.start();
    }
}