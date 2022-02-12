package com.example.TastyApp.UI

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.TastyApp.DATA.model.ItemX
import com.example.TastyApp.DATA.repository.FoodRepository
import com.example.TastyApp.UI.viewmodel.MainViewModel
import com.example.TastyApp.R
import com.example.TastyApp.UI.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_food_detail.*


class FoodDetailActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        viewModel = ViewModelProvider(this, ViewModelFactory(FoodRepository())).get(MainViewModel::class.java)

        if (intent != null) {
            val data = intent.getIntExtra("foodName", -1)
            viewModel.getDetail(data).observe(this, Observer {
                setData(it)
            })
        }
    }

    private fun setData(it: ItemX?) {
        it?.apply {
            tvFoodName.text = "Receipe Name :- "+name
            tvDescription.text = "Description :- "+description
            tvDuration.text = "Time taken :- "+total_time_minutes
            tvLanguage.text = "Language :- "+language
            tvOpening.text = "Opening :- "+is_shoppable
            tvInstruction.text = "Instruction :- "+instructions
            tvCreatedAt.text = "Created Time :- "+created_at
            tvPromotion.text = "Promotion :- "+promotion
            val uri = Uri.parse(video_url)
            instructionalVideo.setVideoURI(uri)
            instructionalVideo.start()

        }
    }
}