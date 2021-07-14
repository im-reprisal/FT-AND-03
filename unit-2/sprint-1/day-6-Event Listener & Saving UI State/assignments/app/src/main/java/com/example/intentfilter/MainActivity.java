package com.example.intentfilter;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     TextView mTvView;
     EditText mEtEnterMessage;
     Button mBtnClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvView = findViewById(R.id.tvView);
        mBtnClick = findViewById(R.id.btnClick);
        mEtEnterMessage = findViewById(R.id.etEnterMessage);
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mEtEnterMessage.getText().toString();
                mTvView.setText(str);
            }
        });
        mEtEnterMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("Tag", "before text" + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("Tag", "on text" + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Tag", "after text" + s.toString());
                if (s.toString().length() >= 6) {
                    Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}