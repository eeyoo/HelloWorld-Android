package com.example.feilin.myapplication.activity;

import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.feilin.myapplication.R;
import com.example.greendao.DaoMaster;
import com.example.greendao.DaoSession;

public class NoteActivity extends ListActivity {

    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
    }


}
