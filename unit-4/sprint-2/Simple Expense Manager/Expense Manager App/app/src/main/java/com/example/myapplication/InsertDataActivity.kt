package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_insert_data.*
import java.text.SimpleDateFormat
import java.util.*

class InsertDataActivity : AppCompatActivity() {
    var dbHandler = DatabaseHandler(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        btnAddData.setOnClickListener {
            var amount = etInputAmt.text.toString().toInt()
            var desc = etInputDesc.text.toString()
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            var currentDate = sdf.format(Date()).toString()
            var category = spinner.selectedItem.toString()

            if (category.equals("Income")){
                dbHandler.insertIncome(amount,desc,currentDate)
            }else{
                dbHandler.insertExpense(amount,desc,currentDate)
            }
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}