package com.example.communication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentB : Fragment(R.layout.fragment_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(CommunicationViewModel::class.java)
        btnFragB.setOnClickListener {
            model.sendMessage("Hello")
        }
        model.liveData.observe(viewLifecycleOwner, Observer {
            tvFragB.text= it
        })
    }
}