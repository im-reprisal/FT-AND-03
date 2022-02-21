package com.example.communication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment(R.layout.fragment_a) {
    private lateinit var sharedViewModel : CommunicationViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity()).get(CommunicationViewModel::class.java)

       btnFragA.setOnClickListener {
           sharedViewModel.sendMessage("Hi")
       }
        sharedViewModel.liveData.observe(viewLifecycleOwner, Observer {
            tvFragA.text= it
        })
    }
}