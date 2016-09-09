package com.example.feilin.myapplication.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.feilin.myapplication.R;

/**
 * Created by feilin on 2016/8/28.
 */
public class ThreadsActivity extends Activity {

    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threads_layout);

        Button playBtn = (Button) findViewById(R.id.thread_btn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        playMusic();
                    }
                }).start();
            }
        });

        //player = MediaPlayer.create(this, R.raw.a4);
        //player.start();
    }

    int[] notes = {R.raw.c5, R.raw.b4, R.raw.a4, R.raw.g4};
    int NOTE_DURATION = 400; //millisec
    boolean paused = false;
    private void playMusic() {
        for (int i=0; i < 12; i++) {
            if (!paused) {
                if (player != null) { player.release(); }
                player = MediaPlayer.create(this, notes[i%4]);
                player.start();
                try {
                    Thread.sleep(NOTE_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onPause() {
        paused = false;
        super.onPause();
    }

    @Override
    protected void onResume() {
        paused = false;
        super.onResume();
    }
}
