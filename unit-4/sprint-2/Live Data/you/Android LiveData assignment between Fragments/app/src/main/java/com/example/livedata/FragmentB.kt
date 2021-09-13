package com.example.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentB : Fragment(R.layout.fragment_b) {
    private val dataClass = DataClass()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnIncCountFragB.setOnClickListener {
            dataClass.incFragBCount()
        }
        dataClass.getMediatorLiveData().observe(viewLifecycleOwner, Observer {
            tvShowCountB.text = it
        })
    }
}