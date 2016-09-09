package com.example.feilin.myapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by feilin on 2016/9/6.
 */
public class TestIntentService extends IntentService {
    private final static String TAG = "IntentService";
    public TestIntentService() {
        super("TestIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "Service Thread id is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy executed.");
    }
}
