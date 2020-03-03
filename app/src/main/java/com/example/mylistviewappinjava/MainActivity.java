package com.example.mylistviewappinjava;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.country_list_view);
        arrayList = new ArrayList<>();
        arrayList = countryList();
        // multiple choice list_view layout
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, arrayList);
        // single choice list_view layout
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, arrayList);
        // simple list_view layout
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        // multiple choice mode
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        // single choice mode
        //listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    private ArrayList<String> countryList() {

        ArrayList<String> strings = new ArrayList<>();

        strings.add("1  Russia");
        strings.add("2  Canada");
        strings.add("3  China");
        strings.add("4  United States");
        strings.add("5  Brazil");
        strings.add("6  Australia");
        strings.add("7  India");
        strings.add("8  Argentina");
        strings.add("9  Kazakhstan");
        strings.add("10 Algeria");

        return strings;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String country = countryList().get(position);
        Toast.makeText(MainActivity.this, country, Toast.LENGTH_LONG).show();
    }
}
