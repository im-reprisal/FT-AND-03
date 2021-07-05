package com.example.applicationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {
    Button mBtnSignUp;
    TextView mTvBtnSignIn;
    EditText mEtName,mEtEmail,mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mBtnSignUp = findViewById(R.id.btnSignUp);
        mEtName = findViewById(R.id.etEnterName);
        mEtEmail = findViewById(R.id.etEnterEmail);
        mEtPassword = findViewById(R.id.etEnterPassword);
        mTvBtnSignIn = findViewById(R.id.tvBtnSignIn);
        mTvBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}