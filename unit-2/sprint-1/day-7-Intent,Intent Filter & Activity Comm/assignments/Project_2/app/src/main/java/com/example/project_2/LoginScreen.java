package com.example.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    private EditText metEmail;
    private EditText metPassword;
    private Button mbtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    private void initializeViewsAndListeners() {
        metEmail = findViewById(R.id.etEmail);
        metPassword = findViewById(R.id.etPassword);
        mbtnLogin = findViewById(R.id.btnLogin);

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCredentialsValid()) {
                    Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
                    intent.putExtra("data", metEmail.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    private boolean isCredentialsValid(){
        String mail = metEmail.getText().toString();
        String pass = metPassword.getText().toString();
        String numRegex   = ".*[0-9].*";
        String alphaRegex = ".*[A-Z].*";

        boolean isDataValid = true ;

        if (!mail.contains("@masaischool.com")){
            metEmail.setError("Invalid Email Id");
            isDataValid =false;
        }

        if (!pass.matches(numRegex) && !pass.matches(alphaRegex)) {
            System.out.println("Password  doesnot contains Alphanumeric");
        }
        return isDataValid;
    }
}