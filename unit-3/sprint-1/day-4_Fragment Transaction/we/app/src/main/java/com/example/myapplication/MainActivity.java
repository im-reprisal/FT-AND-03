package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button AddAmBtn;
    private Button AddBmBtn;
    private Button RemoveAmBtn;
    private Button RemoveBmBtn;
    private Button ReplaceBWithAmBtn;
    private Button ReplaceAWithBWithBackStackmBtn;
    private Button ReplaceAWithBWithoutBackStackmBtn;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        fragmentManager = getSupportFragmentManager();
    }
    private void init() {
        AddAmBtn = findViewById(R.id.AddABtn);
        AddBmBtn =  findViewById(R.id.AddBBtn);
        RemoveAmBtn = findViewById(R.id.RemoveABtn);
        RemoveBmBtn = findViewById(R.id.RemoveBBtn);
        ReplaceBWithAmBtn = findViewById(R.id.ReplaceBWithABtn);
        ReplaceAWithBWithBackStackmBtn = findViewById(R.id.ReplaceAWithBWithBackStackBtn);
        ReplaceAWithBWithoutBackStackmBtn = findViewById(R.id.ReplaceAWithBWithoutBackStackBtn);

        AddAmBtn.setOnClickListener(this);
        AddBmBtn.setOnClickListener(this);
        RemoveAmBtn.setOnClickListener(this);
        RemoveBmBtn.setOnClickListener(this);
        ReplaceBWithAmBtn.setOnClickListener(this);
        ReplaceAWithBWithBackStackmBtn.setOnClickListener(this);
        ReplaceAWithBWithoutBackStackmBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.AddABtn:
                addA();
                break;
            case R.id.AddBBtn:
                addB();
                break;
            case R.id.RemoveABtn:
                removeA();
                break;
            case R.id.RemoveBBtn:
                removeB();
                break;
            case R.id.ReplaceBWithABtn:
                replaceBWithA();
                break;
            case R.id.ReplaceAWithBWithBackStackBtn:
                replaceAWithBWithBackstack();
                break;
            case R.id.ReplaceAWithBWithoutBackStackBtn:
                replaceAWithBWithoutBackstack();
                break;
        }
    }
    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer, fragmentA, "fragmentA").commit();
    }
    private void addB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer, fragmentB, "fragmentB").commit();
    }
    private void removeA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA != null) {
            fragmentTransaction.remove(fragmentA).commit();
        }
    }
    private void removeB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if (fragmentB != null) {
            fragmentTransaction.remove(fragmentB).commit();
        }
    }
    private void replaceBWithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer, fragmentA, "fragmentB").commit();
    }
    private void replaceAWithBWithBackstack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("fragmentB").commit();
    }
    private void replaceAWithBWithoutBackstack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit();
    }
}