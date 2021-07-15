package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
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

    private EditText mEtName;
    private EditText mEtMobileNo;
    private EditText mEtEmail;
    private EditText mEtAddress;
    private EditText mEtManufacturerName;
    private EditText mEtId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();

        Intent intent = getIntent();
        String uName = intent.getStringExtra("Name");
        mEtName.setText(uName);
        String uMobileNumber = intent.getStringExtra("MobileNumber");
        mEtMobileNo.setText(uMobileNumber);
        String uEmail = intent.getStringExtra("Email");
        mEtEmail.setText(uEmail);
        String uAddress = intent.getStringExtra("Address");
        mEtAddress.setText(uAddress);
        String uManufacturerName = intent.getStringExtra("ManufacturerName");
        mEtManufacturerName.setText(uManufacturerName);
        String uID = intent.getStringExtra("ID");
        mEtId.setText(uID);
    }

    private void init() {
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