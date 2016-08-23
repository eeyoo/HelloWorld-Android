package com.example.feilin.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.feilin.myapplication.R;
import com.example.feilin.myapplication.utils.Utility;

public class FilePersistenceActivity extends AppCompatActivity {

    private final static String FILE_NAME = "data";
    private final static String TAG = "feilin";
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_persistence);

        et = (EditText) findViewById(R.id.edit);

        String content = Utility.fileLoad(this, FILE_NAME);

        if (!TextUtils.isEmpty(content)) {
            et.setText(content);
            et.setSelection(content.length());
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String inputText = et.getText().toString();
        Utility.fileSave(this, FILE_NAME, inputText);
        Log.d(TAG, "file persistence successfully.");
    }
}
