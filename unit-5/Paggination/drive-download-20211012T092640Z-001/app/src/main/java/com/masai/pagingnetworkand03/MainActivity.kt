package com.masai.pagingnetworkand03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.pagingnetworkand03.ui.CharacterAdapter
import com.masai.pagingnetworkand03.ui.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        setAdapter()

    }

    private fun setAdapter() {
        characterAdapter = CharacterAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.apply {
            layoutManager = linearLayoutManager
//            this.adapter = characterAdapter
        }
    }
}