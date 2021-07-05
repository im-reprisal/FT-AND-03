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
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUserNameValid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                if (isPasswordValid && isUserNameValid) {
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    intent.putExtra("username",mEtEnterName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    private boolean isPasswordValid() {
        if (mEtEnterPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mEtEnterPassword.setError("Password is weak.");
            return false;
        }
    }
    private boolean isUserNameValid() {
        if (mEtEnterName.getText().toString().trim().length() >= 4) {
            return true;
        } else {
            mEtEnterName.setError("Minimum 4 characters needed");
            return false;
        }
    }
}