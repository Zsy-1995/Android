package com.example.rts.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createdatabase = findViewById(R.id.create_database);
        Button addData = findViewById(R.id.add_data);
        Button upDateData = findViewById(R.id.update_data);
        Button delete = findViewById(R.id.delate_data);
        Button query = findViewById(R.id.query_data);
        createdatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("The zsy Code");
                book.setAuthor("zsy");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("unKnow");
                book.save();
            }
        });
        upDateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setPrice(14.34);
                book.setPress("Anchor");
                book.updateAll("name=? and author=?", "The zsy Code", "zsy");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(Book.class, "price<?", "15");
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book : books) {
                    Log.d(TAG, "11111name"+book.getName());
                    Log.d(TAG, "11111作者"+book.getAuthor());
                    Log.d(TAG, "11111页码"+book.getPages());
                    Log.d(TAG, "11111单价"+book.getPrice());
                    Log.d(TAG, "11111出版社"+book.getPress());
                }
            }
        });
    }
}
