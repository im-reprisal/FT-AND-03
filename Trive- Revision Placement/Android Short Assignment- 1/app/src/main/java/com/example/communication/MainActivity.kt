package com.example.communication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    private var fragmentA: FragmentA? = null
    private var fragmentB: FragmentB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentA = FragmentA()
        fragmentB = FragmentB()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_a, fragmentA!!)
            .replace(R.id.container_b, fragmentB!!)
            .commit()
    }
}