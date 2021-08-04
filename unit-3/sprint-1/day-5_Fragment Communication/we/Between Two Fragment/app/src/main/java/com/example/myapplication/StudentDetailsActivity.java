package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class StudentDetailsActivity extends AppCompatActivity implements CommunicationListener{
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchStudentPersonalDetails();
    }
    private void launchStudentPersonalDetails() {
        fragmentManager = getSupportFragmentManager();
        StudentPersonalDetailsFragment studentPersonalDetailsFragment = new StudentPersonalDetailsFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, studentPersonalDetailsFragment, "personal").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment studentPerformanceDetailsFragment = new StudentPerformanceDetailsFragment();
        studentPerformanceDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container,studentPerformanceDetailsFragment,"performance").addToBackStack("performance").commit();
    }
}