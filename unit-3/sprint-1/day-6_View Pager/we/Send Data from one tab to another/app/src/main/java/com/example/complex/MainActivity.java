package com.example.complex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        setViewPagerAdapter();
    }

    private void setViewPagerAdapter() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setData(String name) {
        this.name = name;
    }

    public void sendDataToSecondFragment(CommunicationListener communicationListener) {
        if (communicationListener != null) {
            communicationListener.onDataPassed(name);
        }
    }

    public void setDataToSecondFragment(SecondFragment secondFragment) {
        if (secondFragment != null) {
            secondFragment.onDataPassed(name);
        }
    }
}