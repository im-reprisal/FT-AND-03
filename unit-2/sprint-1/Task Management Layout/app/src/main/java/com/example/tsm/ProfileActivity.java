package com.example.tsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
    private Button btnfront;
    private Button mbtnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        intidveiws();
        mbtnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void intidveiws() {
        mbtnSignOut=findViewById(R.id.btnSignOut);
    }
}