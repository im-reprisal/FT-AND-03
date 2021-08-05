package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnButton1, mBtnButton2;
    private WorkerThread workerThread;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        workerThread = new WorkerThread();
        workerThread.start();
        Log.d(TAG, "run");

    }

    private void initViews() {
        mBtnButton1 = findViewById(R.id.button1);
        mBtnButton2 = findViewById(R.id.button2);

        mBtnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(task1);
            }
        });

        mBtnButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(task2);
            }
        });
    }

    private Runnable task1 = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "task 1" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable task2 = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "task 2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}