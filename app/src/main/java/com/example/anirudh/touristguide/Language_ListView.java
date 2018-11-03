package com.example.anirudh.touristguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Language_ListView extends AppCompatActivity {

ListView aList=(ListView)findViewById(R.id.list_view);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language__list_view);
        String languagelist[] = new String[]{"English", "Russian", "Dutch", "Chinese", "French", "German", "Hindi", "Italian", "Japanese", "Spanish"};
        Integer[] listviewImage = new Integer[]{
                R.drawable.uk, R.drawable.russian, R.drawable.dutch, R.drawable.chinese,
                R.drawable.french, R.drawable.german, R.drawable.india, R.drawable.italian, R.drawable.spanish


        };
       customlist adapter = new
               customlist(Language_ListView.this, languagelist, listviewImage);
        aList=(ListView)findViewById(R.id.list_view);
        aList.setAdapter(adapter);
        aList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
              //  Toast.makeText(Language_ListView.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }
}
