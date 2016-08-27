package com.example.feilin.myapplication.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.feilin.myapplication.R;
import com.example.feilin.myapplication.receiver.ForceOfflineReceiver;

public class MainActivity extends BaseActivity {

    TextView tv;
    //private IntentFilter intentFilter;
    //private NetworkChangeReceiver networkChangeReceiver;
    private ForceOfflineReceiver receiver;
    private LocalBroadcastManager manager;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.text);

        /*intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);*/
        //force offline
        manager = LocalBroadcastManager.getInstance(this);

        final Button offline = (Button) findViewById(R.id.force_offline);
        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send force offline broadcast
                Intent intent = new Intent("com.example.broadcast.FORCE_OFFLINE");
                //sendBroadcast(intent);
                manager.sendBroadcast(intent);
            }
        });

        receiver = new ForceOfflineReceiver();
        filter = new IntentFilter();
        filter.addAction("com.example.broadcast.FORCE_OFFLINE");
        manager.registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(networkChangeReceiver);
        manager.unregisterReceiver(receiver);
    }

    /*class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //Toast.makeText(context, "Network changed", Toast.LENGTH_SHORT).show();
            ConnectivityManager manager = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "Network is available", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Network is unavailable.", Toast.LENGTH_SHORT).show();
            }
        }
    }*/
}
