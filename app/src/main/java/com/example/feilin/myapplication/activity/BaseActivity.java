package com.example.feilin.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.feilin.myapplication.manager.ActivityCollector;

/**
 * Created by feilin on 2016/8/22.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
