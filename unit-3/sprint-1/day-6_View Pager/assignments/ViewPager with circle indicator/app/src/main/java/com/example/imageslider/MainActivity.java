package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ArrayList<Integer> imagesList = new ArrayList<>();
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        imagesList.add(R.drawable.img6);
        imagesList.add(R.drawable.img2);
        imagesList.add(R.drawable.img3);
        imagesList.add(R.drawable.img5);
        imagesList.add(R.drawable.img7);
        viewPagerAdapter = new ViewPagerAdapter(this,imagesList);
        viewPager.setPadding(100,0,100,0);
        viewPager.setAdapter(viewPagerAdapter);
    }
}