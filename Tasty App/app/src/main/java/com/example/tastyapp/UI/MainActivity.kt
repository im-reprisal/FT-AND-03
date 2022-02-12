package com.example.TastyApp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.TastyApp.R

class MainActivity : AppCompatActivity() {
    private val discoverFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(discoverFragment)
    }
    private fun replaceFragment(fragment:Fragment){
        if (fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.flFrameLayout,fragment)
            transaction.commit()
        }
    }
}