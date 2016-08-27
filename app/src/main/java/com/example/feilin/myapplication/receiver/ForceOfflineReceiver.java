package com.example.feilin.myapplication.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;

import com.example.feilin.myapplication.activity.LoginActivity;
import com.example.feilin.myapplication.manager.ActivityCollector;

/**
 * Created by feilin on 2016/8/23.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    private final static String TAG = "feilin";

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d(TAG, "force offline receiver.");

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("警告");
        dialogBuilder.setMessage("将执行强制下线，需要重新登录");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCollector.finishAll();
                        Intent login = new Intent(context, LoginActivity.class);
                        login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(login);
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
