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
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mBtnButton = mBtnButton.findViewById(R.id.button);
        mTVText = mTVText.findViewById(R.id.tvMessage);

        registerLocalReceiver();
        mBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.and03.broadcast");
                intent.putExtra("key","Hello Masai School");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }
    private void registerLocalReceiver(){
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.and03.broadcast");
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }
    private class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent!=null) {
                String data = intent.getStringExtra("key");
                mTVText.setText(data);
            }
        }
    }
}