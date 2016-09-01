package com.example.feilin.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.feilin.myapplication.R;
import com.example.feilin.myapplication.adapter.FruitAdapter;
import com.example.feilin.myapplication.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Orange", "Banana", "Watermelon", "Pear",
            "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initFruits();

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //        android.R.layout.simple_list_item_1, data);

        FruitAdapter adapter = new FruitAdapter(this,
                R.layout.fruit_item, fruitList);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    private void initFruits() {
        Fruit apple = new Fruit("Apple", R.drawable.pp01);
        fruitList.add(apple);
        Fruit orange = new Fruit("Orange", R.drawable.pp02);
        fruitList.add(orange);
        Fruit banana = new Fruit("Banana", R.drawable.pp03);
        fruitList.add(banana);
        Fruit watermelon = new Fruit("Watermelon", R.drawable.pp04);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.drawable.pp05);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape", R.drawable.pp06);
        fruitList.add(grape);
        Fruit pin = new Fruit("Pineapple", R.drawable.pp07);
        fruitList.add(pin);
        Fruit str = new Fruit("Strawberry", R.drawable.pp08);
        fruitList.add(str);
        Fruit cherry = new Fruit("Cherry", R.drawable.pp09);
        fruitList.add(cherry);
        Fruit mango = new Fruit("Mango", R.drawable.pp10);
        fruitList.add(mango);
    }
}
