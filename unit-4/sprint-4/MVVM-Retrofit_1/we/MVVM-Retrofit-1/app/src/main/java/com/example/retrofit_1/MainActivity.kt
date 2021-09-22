package com.example.retrofit_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.retrofit_1.models.local.TaskAppDao
import com.example.retrofit_1.models.local.TaskRoomDatabase
import com.example.retrofit_1.models.remote.Status
import com.example.retrofit_1.models.remote.requests.LoginRequestModel
import com.example.retrofit_1.repository.TaskRepo
import com.example.retrofit_1.viewmodels.TaskViewModel
import com.example.retrofit_1.viewmodels.TaskViewModelFactory
import org.jetbrains.anko.longToast


class MainActivity() : AppCompatActivity(){
    lateinit var viewModel: TaskViewModel
    lateinit var roomDb: TaskRoomDatabase
    lateinit var taskDao: TaskAppDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        roomDb = TaskRoomDatabase.getDatabaseObject(this)
        taskDao = roomDb.getTaskDAO()

        val repo = TaskRepo(taskDao)
        val viewModelFactory = TaskViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TaskViewModel::class.java)

        val loginRequestModel = LoginRequestModel(
            userName = "pradeep1706108@gmail.com",
            password = "dhankhar")


        viewModel.userLogin(loginRequestModel).observe(this, Observer {
            val response = it

            //checking the response (success or failure)
            when (response.status) {
                Status.SUCCESS -> {
                    //get the response
                    val name = response.data?.user?.name!!
                    val email = response.data?.user?.email!!
                    longToast("$name and $email")

                }
                Status.ERROR -> {
                    //will show the error
                    val error = response.message!!
                    longToast("$error")
                }
                Status.LOADING -> {
                    //waiting for the response
                    val loading = "Loading"
                    longToast("$loading")
                }
            }
        })
    }
}
