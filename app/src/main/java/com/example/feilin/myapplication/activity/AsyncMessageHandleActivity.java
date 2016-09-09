package com.example.feilin.myapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.feilin.myapplication.R;


public class AsyncMessageHandleActivity extends AppCompatActivity implements View.OnClickListener {

    public final static int UPDATE_TEXT = 1;

    private TextView text;
    private Button changeText;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_TEXT:
                    text.setText("Nice to meet u too.");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_tutorial);

        text = (TextView) findViewById(R.id.service_text);
        changeText = (Button) findViewById(R.id.service_btn);

        changeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.service_btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //text.setText("Nice to meet u.");
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        //send message to Main UI thread
                        //handler.handleMessage(message);
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
