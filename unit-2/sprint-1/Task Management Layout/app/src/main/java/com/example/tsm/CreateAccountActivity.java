package com.example.tsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {
    private Button mbutton;
    private Button mbtnback;
    private EditText metemail;
    private EditText metpassword;
    private EditText metpassword1;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        intidview();
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmailVlaid() && ispasswordmatch()) {
                    Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        mbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccountActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void intidview() {
        mbtnback = findViewById(R.id.btnback);
        mbutton = findViewById(R.id.button);
        metemail = findViewById(R.id.etemail);
        metpassword = findViewById(R.id.etpassword);
        metpassword1 = findViewById(R.id.etpassword1);
    }

    private boolean isEmailVlaid() {
        if (metemail.getText().toString().length() >= 1 &&
                metemail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            metemail.setError("InvalidEmail");
            return false;
        }
    }

    private boolean ispasswordmatch(){
        if(metpassword.getText().toString().equals(metpassword1.getText().toString())){
            return true;
        }else{
            Toast.makeText(CreateAccountActivity.this,"password not match",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}