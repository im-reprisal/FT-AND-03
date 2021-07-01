package com.example.intent_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText metEmailId;
    private EditText metPassword;
    private EditText metConfirmPassword;
    private EditText metPhoneNumber;
    private Button mBtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViewsAndListeners();
    }
    private void initializeViewsAndListeners(){
        metEmailId = findViewById(R.id.etEmailId);
        metPassword = findViewById(R.id.etPassword);
        metConfirmPassword = findViewById(R.id.etConfirmPassword);
        metPhoneNumber = findViewById(R.id.etPhone);
        mBtnSignUp = findViewById(R.id.btnSignUp);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCredentialsValid()){
                    Intent intent = new Intent(MainActivity.this , Login.class);
                    intent.putExtra("data", metEmailId.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    private boolean isCredentialsValid(){
        String checkemail = metEmailId.getText().toString();
        String pass = metPassword.getText().toString();
        String cpass = metConfirmPassword.getText().toString();
        String phone = metPhoneNumber.getText().toString();

        boolean isDataValid = true ;

        if (!checkemail.contains("@masaischool.com")){
            metEmailId.setError("Invalid Email Id");
            isDataValid =false;
        }
        if (pass.length() < 6 && cpass.length() < 6){
            metPassword.setError("Password length is less than 6 characters");
            isDataValid =false;
        }
        if(!pass.equals(cpass)){
            Toast.makeText(MainActivity.this,"Password Not match",Toast.LENGTH_SHORT).show();
            isDataValid = false;
        }
        if(phone.length() > 10 && phone.length() < 10){
            Toast.makeText(MainActivity.this,"Password Not matching",Toast.LENGTH_SHORT).show();
            isDataValid = false;
        }
        return isDataValid;
    }

}