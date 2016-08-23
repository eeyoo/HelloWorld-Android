package com.example.feilin.myapplication.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.feilin.myapplication.R;

/**
 * send and receive local broadcast available in your app
 */
public class LocalBroadcastActivity extends AppCompatActivity {

    private final static String LOCAL_ACTION = "com.example.broadcast.test.LOCAL_BROADCAST";

    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        final Button sendLocalBroadcast = (Button) findViewById(R.id.send_local_broadcast);
        sendLocalBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LOCAL_ACTION);
                // send local broadcast
                localBroadcastManager.sendBroadcast(intent);


            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction(LOCAL_ACTION);
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
