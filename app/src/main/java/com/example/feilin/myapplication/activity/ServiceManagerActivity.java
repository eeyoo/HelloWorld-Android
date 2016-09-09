package com.example.feilin.myapplication.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.feilin.myapplication.R;
import com.example.feilin.myapplication.service.TestIntentService;
import com.example.feilin.myapplication.service.TestService;

public class ServiceManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start, stop;
    private Button bind, unbind;
    private Button service;

    private TestService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (TestService.DownloadBinder) iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_manager);

        start = (Button) findViewById(R.id.service_start);
        stop = (Button) findViewById(R.id.service_stop);

        bind = (Button) findViewById(R.id.service_bind);
        unbind = (Button) findViewById(R.id.service_unbind);

        service = (Button) findViewById(R.id.intentservice_bind);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);

        service.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.service_start:
                Intent intentStart = new Intent(this, TestService.class);
                startService(intentStart);
                break;
            case R.id.service_stop:
                Intent intentStop = new Intent(this, TestService.class);
                stopService(intentStop);
                break;
            case R.id.service_bind:
                Intent intentBind = new Intent(this, TestService.class);
                bindService(intentBind, connection, BIND_AUTO_CREATE);
                break;
            case R.id.service_unbind:
                unbindService(connection);
                break;
            case R.id.intentservice_bind:
                Log.d("IntentService", "Main Thread id is " + Thread.currentThread().getId());
                Intent intentService = new Intent(this, TestIntentService.class);
                startService(intentService);
                break;
            default:
                break;
        }
    }
}
