package com.example.tsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button mbutton;
    private Button mbtnforgotpassword;
    private Button mbtnback;
    private EditText metemail;
    private EditText metpassword;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intidviews();
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void intidviews() {
        mbutton = findViewById(R.id.button);
        mbtnforgotpassword = findViewById(R.id.btnforgotpassword);
        mbtnback = findViewById(R.id.btnback);
    }
}