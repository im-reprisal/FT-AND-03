package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
public class MainActivity extends AppCompatActivity implements CommunicationListener {

    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.flContainer);
        launchStudentPersonalDetailsFrag();
    }

    private void launchStudentPersonalDetailsFrag() {
        fragmentManager = getSupportFragmentManager();
        StudentPersonalDetailsFragment studentPersonalDetailsFragment = new StudentPersonalDetailsFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flContainer, studentPersonalDetailsFragment, "StudentPersonal").commit();
    }

    @Override
    public void launchStudentPerformanceDetailsFrag(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment studentPerformanceDetailsFragment = new StudentPerformanceDetailsFragment();
        studentPerformanceDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flContainer,studentPerformanceDetailsFragment,"StudentPerformance").addToBackStack("StudentPerformance").commit();
    }
}