package com.example.feilin.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.feilin.myapplication.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    private final static String ACTION = "com.example.broadcast.test.BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        final Button sendBroadcast = (Button) findViewById(R.id.send_broadcast);
        sendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACTION);
                //sendBroadcast(intent);
                sendOrderedBroadcast(intent, null);
            }
        });
    }
}
