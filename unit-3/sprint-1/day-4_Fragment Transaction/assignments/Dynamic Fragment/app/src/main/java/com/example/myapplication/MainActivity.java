package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    FrameLayout flContainer;
    FragmentManager fragmentManager;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.tvLinearLayout);
        flContainer = findViewById(R.id.flContainer);
        fragmentManager = getSupportFragmentManager();
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace();
            }
        });
    }

    private void replace() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentName = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer,fragmentName,"fragmentA").commit();
    }
}