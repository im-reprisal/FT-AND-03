package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insert_data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InsertTaskActivity : AppCompatActivity() {
    lateinit var roomDb: TaskRoomDataBase
    lateinit var dataDAO: TaskDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)
        roomDb = TaskRoomDataBase.getDataBaseObject(this)
        dataDAO = roomDb.getDataDAO()

        btnAddData.setOnClickListener {
            var amount = etInputAmt.text.toString().toInt()
            var desc = etInputDesc.text.toString()
            var category = spinner.selectedItem.toString()

            val dataModel = TaskModel(category,amount,desc)
            CoroutineScope(Dispatchers.IO).launch {
                dataDAO.addData(dataModel)
                Toast.makeText(this,"Data inserted")
            }
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}