package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mtvaddbuyer;
    private EditText mEtOrganizationName;
    private TextView mTvDetails;
    private TextView mTvName;
    private TextView mTvEmail;
    private TextView mTvAddress;
    private TextView mtvManufacturer;
    private TextView mTvThanks;
    private TextView mTvId;
    private TextView mTvMobileNo;
    private Button mBtnClick;
    private EditText mEtName;
    private EditText mEtMobileNo;
    private EditText mEtEmail;
    private EditText mEtAddress;
    private EditText mEtManufacturerName;
    private EditText mEtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("Name",mEtName.getText().toString());
                intent.putExtra("MobileNumber",mEtMobileNo.getText().toString());
                intent.putExtra("Email",mEtEmail.getText().toString());
                intent.putExtra("Address",mEtAddress.getText().toString());
                intent.putExtra("ManufacturerName",mEtManufacturerName.getText().toString());
                intent.putExtra("ID",mEtId.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void init() {
        mBtnClick = findViewById(R.id.btnClick);
        mEtOrganizationName = findViewById(R.id.etOrganisationName);
        mTvDetails = findViewById(R.id.Details);
        mTvName = findViewById(R.id.tvName);
        mTvMobileNo = findViewById(R.id.tvMobileNo);
        mTvEmail = findViewById(R.id.tvEmail);
        mTvAddress = findViewById(R.id.tvAddress);
        mtvManufacturer = findViewById(R.id.tvManufacturerName);
        mTvId = findViewById(R.id.tvId);
        mEtName= findViewById(R.id.etName);
        mEtMobileNo = findViewById(R.id.etMobileNo);
        mEtEmail = findViewById(R.id.etEmail);
        mEtAddress = findViewById(R.id.etAddress);
        mEtManufacturerName = findViewById(R.id.etManufacturerName);
        mEtId = findViewById(R.id.etId);
    }
}