package com.example.complex;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment implements CommunicationListener{

    private MainActivity mainActivity;
    private TextView mTvData;

    public static SecondFragment newInstance(){
        SecondFragment secondFragment = new SecondFragment();
        return secondFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvData = view.findViewById(R.id.tvData);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentB","onResume");

        if (mainActivity != null){
            mainActivity.setDataToSecondFragment(this);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("FragmentB","onStart");
    }

    @Override
    public void onDataPassed(String data) {
        mTvData.setText(data);
    }
}