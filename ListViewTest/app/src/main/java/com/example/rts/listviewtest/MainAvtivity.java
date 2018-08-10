package com.example.rts.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainAvtivity extends AppCompatActivity {

//    private String [] data = {
//      "A","B","C","D","D","D1","D2","D3","D4","D5","D6","D7","D8","D9",
//            "D10","D11","D12","D12","D12","D12","D12","D12","D12","D12"
//    };
    private List<Fruit> fruitList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainAvtivity.this, R.layout.fruit_item, fruitList);

//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
//                MainAvtivity.this,android.R.layout.simple_list_item_1,data
//        );
        ListView listView =  findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainAvtivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruits() {
        for (int i=0;i<2;i++) {
            Fruit a = new Fruit("A", R.drawable.cloud);
            fruitList.add(a);
            Fruit b = new Fruit("B", R.drawable.earth);
            fruitList.add(b);
            Fruit c = new Fruit("C", R.drawable.planet);
            fruitList.add(c);
            Fruit d = new Fruit("D", R.drawable.radar);
            fruitList.add(d);
            Fruit e = new Fruit("E", R.drawable.rocket);
            fruitList.add(e);
            Fruit f = new Fruit("F", R.drawable.satellite);
            fruitList.add(f);
            Fruit g = new Fruit("G", R.drawable.ship);
            fruitList.add(g);
            Fruit h = new Fruit("H", R.drawable.star);
            fruitList.add(h);
            Fruit k = new Fruit("H", R.drawable.sun);
            fruitList.add(k);
            Fruit l = new Fruit("H", R.drawable.telescope);
            fruitList.add(l);
            Fruit n = new Fruit("H", R.drawable.tuxing);
            fruitList.add(n);
            Fruit o = new Fruit("H", R.drawable.tuxing);
            fruitList.add(o);
            Fruit p = new Fruit("H", R.drawable.tuxing);
            fruitList.add(p);

        }
    }
}
