package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtAddress;
    private EditText mEtCc;
    private EditText mEtMessage;
    private Button mBtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSend = findViewById(R.id.btnSend);
        mEtCc = findViewById(R.id.etCc);
        mEtAddress = findViewById(R.id.etAddress);
        mEtMessage = findViewById(R.id.etMessage);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = mEtAddress.getText().toString();
                String cc = mEtCc.getText().toString();
                String message = mEtAddress.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, " email subject");
                emailIntent.putExtra(Intent.EXTRA_CC, new String[]{cc});
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                emailIntent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(emailIntent);
            }
        });
    }
}