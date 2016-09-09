package com.example.feilin.myapplication.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.feilin.myapplication.R;

public class ActivityDownloadAsyncTask extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_download_async_task);

        progressDialog = new ProgressDialog(this);

        Button action = (Button) findViewById(R.id.asynctask_btn);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadTask().execute();
            }
        });
    }

    private class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            /*try {
                publishProgress(0);
                Thread.sleep(3000);
                publishProgress(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setMessage(values[0] + "%");
            //super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            progressDialog.dismiss();
            Toast.makeText(ActivityDownloadAsyncTask.this, "done", Toast.LENGTH_SHORT).show();
            //super.onPostExecute(aBoolean);
        }
    }
}
