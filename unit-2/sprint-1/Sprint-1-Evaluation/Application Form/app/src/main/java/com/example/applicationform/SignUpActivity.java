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
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

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
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUserNameValid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailValid = isEmailValid();
                if (isEmailValid && isPasswordValid && isUserNameValid) {
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    intent.putExtra("username",mEtName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
        private boolean isEmailValid() {
            if (mEtEmail.getText().toString().matches(emailValidation)) {
                return true;
            } else {
                mEtEmail.setError("Invalid email");
                return false;
            }
        }
        private boolean isPasswordValid() {
            if (mEtPassword.getText().toString().length() >= 6) {
                return true;
            } else {
                mEtPassword.setError("Password is weak.");
                return false;
            }
        }
        private boolean isUserNameValid() {
            if (mEtName.getText().toString().trim().length() >= 4) {
                return true;
            } else {
                mEtName.setError("Minimum 4 characters needed");
                return false;
            }
        }
    }
