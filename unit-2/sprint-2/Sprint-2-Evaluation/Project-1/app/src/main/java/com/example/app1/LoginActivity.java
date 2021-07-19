package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
   private EditText mEtEmail;
   private EditText mEtPassword;
   private CheckBox mEtCheckbox;
   private Button mBtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mEtCheckbox = findViewById(R.id.checkBox);
        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidity()==true) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public boolean checkValidity(){
        String email = mEtPassword.getText().toString();
        String password = mEtPassword.getText().toString();
        if (email.isEmpty()){
            mEtEmail.setError("Email address should not be empty");
        }
        else if (email.contains("@gmail.com")){
            mEtEmail.setError("Please enter a valid email");
        }
        if (password.isEmpty()){
            mEtPassword.setError("Password should not be empty");
        }
        else if (password.length() < 6){
            mEtPassword.setError("Password is very short");
        }
        return true;
    }
}