package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText mEtEnterName;
    private Button mBtnSaveName;
    private ProgressBar progressIndicator;
    private TextView mTvShowName;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {
        mEtEnterName = findViewById(R.id.etName);
        mTvShowName = findViewById(R.id.tvShowName);
        progressIndicator = findViewById(R.id.progressbar);
        mBtnSaveName = findViewById(R.id.btnSaveName);
        mBtnSaveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncTask.execute();
                progressIndicator.setVisibility(View.VISIBLE);
            }
        });
    }
    public String getName() {
        int count = 0;
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(1000);
                count = count + 10;
                progressIndicator.setProgress(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Display";
    }
    private AsyncTask<String, Void, String> asyncTask = new AsyncTask<String, Void, String>() {
        @Override
        protected String doInBackground(String... strings) {
            String name = mEtEnterName.getText().toString();
            String output = getName()+" : "+name;
            return output;
        }

        @Override
        protected void onPostExecute(String s) {
            mTvShowName.setVisibility(View.VISIBLE);
            progressIndicator.setVisibility(View.GONE);
            mTvShowName.setText(s);
        }

    };
}