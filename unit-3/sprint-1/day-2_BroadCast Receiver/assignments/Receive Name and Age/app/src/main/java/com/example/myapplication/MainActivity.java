package com.example.myapplication;

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
    Button btnSend;
    TextView tvName, tvAge;
    LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        tvAge = findViewById(R.id.tvAge);
        tvName = findViewById(R.id.tvName);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        RegisterLocalreciever();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("www.details.com");
                intent.putExtra("name", "Nishant");
                intent.putExtra("age", "24");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }
    private void RegisterLocalreciever() {
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("www.details.com");
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }
    private class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String name = intent.getStringExtra("name");
                String age = intent.getStringExtra("age");
                tvAge.setText(age);
                tvName.setText(name);
            }
        }
    }
}