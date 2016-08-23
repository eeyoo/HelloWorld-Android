package com.example.feilin.myapplication.activity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.feilin.myapplication.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    private final static String FILE_NAME = "data";
    private final static String TAG = "feilin";

    private Button bt;
    private Button readBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        bt = (Button) findViewById(R.id.button);
        readBtn = (Button) findViewById(R.id.button2);

        final StringBuffer content = new StringBuffer();

        //保存SharedPreferences数据
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME,
                        MODE_PRIVATE).edit();
                editor.putString("name", "汤姆");
                editor.putInt("age", 28);
                editor.putBoolean("married", false);
                editor.commit();

                Log.d(TAG, "save SharedPreferences file successfully.");
            }
        });
        //读取SharedPreferences数据
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);

                content.append("姓名 " + preferences.getString("name", "") + "\n");
                content.append("年龄 " + preferences.getInt("age", 0) + "\n");
                content.append("婚否 " + preferences.getBoolean("married", false) + "\n");

                Toast.makeText(SharedPreferencesActivity.this, content.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
