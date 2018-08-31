package com.example.rts.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 4);
        Button createdatabase = findViewById(R.id.create_database);
        Button addData = findViewById(R.id.add_data);
        Button upDate = findViewById(R.id.update_data);
        Button deleteDate = findViewById(R.id.delate_data);
        Button query = findViewById(R.id.query_data);
        createdatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","the zsy code");
                values.put("author","Dan brown");
                values.put("pages",454);
                values.put("price",16.96);
                db.insert("Book", null, values);
                values.clear();
                values.put("name","the last symbol");
                values.put("author","dan brown");
                values.put("pages",510);
                values.put("price",19.95);
                db.insert("Book", null, values);
                }
        });
        upDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                db.update("Book", values, "name=?", new String[]{
                        "the last symbol"
                });
            }
        });
        deleteDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "pages>?", new String[]{"500"});

            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        Double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG, "111111name:"+name);
                        Log.d(TAG, "111111author:"+author);
                        Log.d(TAG, "111111pages:"+pages);
                        Log.d(TAG, "111111price:"+price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
