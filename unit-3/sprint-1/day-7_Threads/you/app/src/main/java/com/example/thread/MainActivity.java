package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStart;
    private ProgressBar progressBar;
    private TextView showPercentage;
    private WorkerThread workerThread;
    private Handler handler;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerThread = new WorkerThread();
        handler = new Handler();
        workerThread.start();
        initViews();
    }

    private void initViews() {
        mBtnStart = findViewById(R.id.btnStart);
        progressBar = findViewById(R.id.progressbar);
        showPercentage = findViewById(R.id.percent);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(task);
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
    private Runnable task = new Runnable() {
        @Override
        public void run() {

            for (int i = 0; i <= 10; i++) {
                count = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(count);
                        if (count == 10) {
                            showPercentage.setText("Task Completed");
                            progressBar.setVisibility(View.INVISIBLE);
                        } else {
                            showPercentage.setText((count)+" % "+" loading");
                        }
                    }
                });
            }
        }
    };
}