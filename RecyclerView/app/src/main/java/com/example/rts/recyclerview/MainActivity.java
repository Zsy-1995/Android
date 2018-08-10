package com.example.rts.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();   //初始化水果数据
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

    }

    private void initFruits() {
        for (int i = 0; i < 4; i++) {
            Fruit a = new Fruit(getRandomLengthName("AAAAAAAAAVZXCV"), R.drawable.cloud);
            fruitList.add(a);
            Fruit b = new Fruit(getRandomLengthName("BBBBBBBBBB"), R.drawable.earth);
            fruitList.add(b);
            Fruit c = new Fruit(getRandomLengthName("C1111111111111"), R.drawable.planet);
            fruitList.add(c);
            Fruit d = new Fruit(getRandomLengthName("D33333333333"), R.drawable.radar);
            fruitList.add(d);
            Fruit e = new Fruit(getRandomLengthName("E44444"), R.drawable.rocket);
            fruitList.add(e);
            Fruit f = new Fruit(getRandomLengthName("F5555"), R.drawable.satellite);
            fruitList.add(f);
            Fruit g = new Fruit(getRandomLengthName("G55555"), R.drawable.ship);
            fruitList.add(g);
            Fruit h = new Fruit(getRandomLengthName("H666"), R.drawable.star);
            fruitList.add(h);
            Fruit k = new Fruit(getRandomLengthName("H77777777777777"), R.drawable.sun);
            fruitList.add(k);
            Fruit l = new Fruit(getRandomLengthName("7777HASDFGASDGA"), R.drawable.telescope);
            fruitList.add(l);
            Fruit n = new Fruit(getRandomLengthName("H7777777777777567"), R.drawable.tuxing);
            fruitList.add(n);
            Fruit o = new Fruit(getRandomLengthName("456745678H"), R.drawable.tuxing);
            fruitList.add(o);
            Fruit p = new Fruit(getRandomLengthName("H23452345"), R.drawable.tuxing);
            fruitList.add(p);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
