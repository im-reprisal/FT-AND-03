package com.example.applicationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {
   Button mBtnSignIn;
   TextView mTvBtnSignUp;
   EditText mEtEnterName,mEtEnterPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mBtnSignIn = findViewById(R.id.btnSignIn);
        mEtEnterName = findViewById(R.id.etEnterNameLog);
        mEtEnterPassword = findViewById(R.id.etEnterPasswordLog);
        mTvBtnSignUp = findViewById(R.id.tvBtnSignUp);
        mTvBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}