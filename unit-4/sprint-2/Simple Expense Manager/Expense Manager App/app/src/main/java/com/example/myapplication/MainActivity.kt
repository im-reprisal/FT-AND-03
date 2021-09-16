package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentAdapter = ConnectFragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(IncomeFragment(),"Income")
        fragmentAdapter.addFragment(ExpenseFragment(),"Expense")
        fragmentAdapter.addFragment(BalanceFragment(),"Balance")

        viewPager.adapter= fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            intent = Intent(this,InsertDataActivity::class.java)
            startActivity(intent)
        }
    }
}