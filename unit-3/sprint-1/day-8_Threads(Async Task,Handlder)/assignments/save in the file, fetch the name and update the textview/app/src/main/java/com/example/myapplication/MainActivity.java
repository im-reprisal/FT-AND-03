package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "name.txt";
    private EditText mEtEnterName;
    private Button mBtnSaveName;
    private ProgressBar progressIndicator;
    private TextView mTvShowName;
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
            }
        });
    }
    private void save(){
        String name = mEtEnterName.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(name.getBytes());
            mEtEnterName.getText().clear();
            Toast.makeText(this,"Saved to "+getFilesDir()+"/"+FILE_NAME,Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void show(){
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String name;
            while ((name = br.readLine()) != null){
                sb.append(name).append("\n");
            }
            mTvShowName.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            save();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            show();
        }
    };
}