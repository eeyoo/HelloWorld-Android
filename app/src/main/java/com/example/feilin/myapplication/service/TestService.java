package com.example.feilin.myapplication.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.feilin.myapplication.R;
import com.example.feilin.myapplication.activity.ServiceManagerActivity;


/**
 * Created by feilin on 2016/9/6.
 */
public class TestService extends Service {

    private final static String TAG = "myservice";
    private DownloadBinder mBinder = new DownloadBinder();

    public class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d(TAG, "start download executed.");
        }

        public int getProgress() {
            Log.d(TAG, "progress executed.");
            return 0;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "service created.");
        /*Notification notification = new Notification(R.mipmap.ic_launcher, "通知栏", System.currentTimeMillis());
        Intent notificationIntent = new Intent(this, ServiceManagerActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        notification.
        startForeground(1, notification);*/
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "service destroyed.");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "service start command.");
        return super.onStartCommand(intent, flags, startId);
    }
}
