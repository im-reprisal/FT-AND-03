package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context,MainActivity2.class);
        String data = intent.getStringExtra("message");
        intent2.putExtra("message",data);
        context.startActivity(intent2);
    }
}
