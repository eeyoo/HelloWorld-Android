package com.example.feilin.myapplication.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.feilin.myapplication.R;
import com.example.feilin.myapplication.db.DatabaseHelper;

import java.io.BufferedReader;

public class SQLiteDatabaseActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);

        dbHelper = new DatabaseHelper(this, "BookStore.db", null, 1);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create batabase
                dbHelper.getWritableDatabase();
            }
        });

        final Button updateDatabaseBtn = (Button) findViewById(R.id.update_database);
        updateDatabaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.onUpgrade(db, 1, 2);
            }
        });

        final Button queryDataBtn = (Button) findViewById(R.id.query_data);
        queryDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                StringBuffer content = new StringBuffer();

                Cursor cursor = db.rawQuery("select * from Book", new String[0]);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        content.append("书名: " + name + "\n");
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        content.append("作者: " + author + "\n");
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        content.append("页数: " + pages + "\n");
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        content.append("价格: " + price + "\n");
                        content.append("--------------------------\n");
                    } while (cursor.moveToNext());
                }
                Toast.makeText(SQLiteDatabaseActivity.this, content.toString(), Toast.LENGTH_LONG).show();


                cursor.close();
            }
        });

        final Button insertData = (Button) findViewById(R.id.insert_data);
        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                insertBookData(db, "The Da Vinci Code", "Dan Brown", 454, 16.96);

                //insertBookData(db, "The Lost Symbol", "Dan Brown", 510, 19.95);
                Log.d("feilin", "insert 2 book datas");
            }
        });

        final Button updateDataBtn = (Button) findViewById(R.id.update_data);
        updateDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 19.99);
                //update book price
                updateBookDataByName(db, values, "The Da Vinci Code");
                Log.d("feilin", "update book data success.");
            }
        });

        final Button deleteDataBtn = (Button) findViewById(R.id.delete_data);
        deleteDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                deleteBookData(db, "pages > ? or price > ?", new String[] {"500", "19.00"});
                Log.d("feilin", "delete book data success.");
            }
        });
    }

    private void insertBookData(SQLiteDatabase db, String name, String author, int pages, double price) {
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("author", author);
        values.put("pages", pages);
        values.put("price", price);
        // insert data into database
        db.insert("Book", null, values);
    }

    private void updateBookDataByName(SQLiteDatabase db, ContentValues values, String name) {
        db.update("Book", values, "name = ?", new String[] {name});
    }

    private void deleteBookData(SQLiteDatabase db, String selections, String[] selectionArgs) {
        db.delete("Book", selections, selectionArgs);
    }
}
