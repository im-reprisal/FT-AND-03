package com.example.communication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommunicationViewModel : ViewModel() {
    private val message = MutableLiveData<String>()
    val liveData: LiveData<String> = message

    fun sendMessage(newMessage:String){
        message.value =newMessage
    }
}