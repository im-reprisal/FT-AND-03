package com.example.app1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final String FILE_NAME = "myFile" ;
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
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String emailid = sharedPreferences.getString("EmailId","");
        String Password = sharedPreferences.getString("Password","");
        mEtEmail.setText(emailid);
        mEtPassword.setText(Password);
        if(mEtCheckbox.isChecked()){
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        else if(!mEtCheckbox.isChecked()) {
            mBtnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isEmailValid() && isPasswordValid()) {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                    String Emailid = mEtEmail.getText().toString();
                    String Password = mEtPassword.getText().toString();

                    if (mEtCheckbox.isChecked()) {
                        StoreData(Emailid, Password);
                    }
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            });
        }
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
    private void StoreData(String Emailid, String Password) {
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
        editor.putString("EmailId",Emailid);
        editor.putString("Password",Password);
        editor.apply();

    }
}