package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private TextView mTVText;
    private Button mBtnButton;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnButton = findViewById(R.id.button);
        mTVText = findViewById(R.id.tvMessage);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        registerLocalReceiver();
        mBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("www.masai.com");
                intent.putExtra("data", "Hello Masai School");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }
    private void registerLocalReceiver() {
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("www.masai.com");
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }
    private class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent!=null){
                String data = intent.getStringExtra("data");
                mTVText.setText(data);
            }
        }
    }
}