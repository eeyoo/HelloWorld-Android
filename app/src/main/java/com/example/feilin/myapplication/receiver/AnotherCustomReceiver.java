package com.example.feilin.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by feilin on 2016/8/22.
 */
public class AnotherCustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "receive broadcast in AnotherCustomReceiver", Toast.LENGTH_SHORT).show();
    }
}
