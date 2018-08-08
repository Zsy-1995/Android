package com.example.rts.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainAvtivity extends AppCompatActivity {

    private String [] data = {
      "A","B","C","D","D","D1","D2","D3","D4","D5","D6","D7","D8","D9",
            "D10","D11","D12","D12","D12","D12","D12","D12","D12","D12"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainAvtivity.this, R.layout.fruit_item,fruitList);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                MainAvtivity.this,android.R.layout.simple_list_item_1,data
        );
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i=0;i<=2;i++) {
            Fruit a = new Fruit("A", R.drawable.cloud);
            fruitList.add
        }
    }
}
