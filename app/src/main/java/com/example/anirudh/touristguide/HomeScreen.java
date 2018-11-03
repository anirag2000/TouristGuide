package com.example.anirudh.touristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }
    public void Tourist_Home_Screen(View view)
    {
        Intent intent=new Intent(HomeScreen.this,Tourist_Home_Screen.class);
        startActivity(intent);
    }
    public void Guide_Home_Screen(View view)
    {
        Intent intent=new Intent(HomeScreen.this,Guide_Home_Screen.class);

        startActivity(intent);
    }
}
