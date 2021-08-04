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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private EditText mEtEnteredData;
    private Button mBtnSendData;

    private MainActivity mainActivity;

    public static FirstFragment newInstance(){
        FirstFragment firstFragment = new FirstFragment();
        return firstFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        mEtEnteredData = view.findViewById(R.id.etEnterData);
        mBtnSendData = view.findViewById(R.id.btnSendData);

        mBtnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainActivity != null){
                    mainActivity.setData(mEtEnteredData.getText().toString());
                }
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentA","onResume");
    }
}