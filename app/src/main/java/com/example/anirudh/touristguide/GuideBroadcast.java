package com.example.anirudh.touristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GuideBroadcast extends AppCompatActivity {
    private DatabaseReference mDatabase;
    String intentuid;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_broadcast);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        Intent intent=getIntent();
        intentuid=intent.getStringExtra("uid");
    }
    public void broadcas(View view)
    {
        try {
            ed1 = (EditText) findViewById(R.id.editText);
            String message = ed1.getText().toString();
            Guide_User user = new Guide_User(message);
            mDatabase.child("guidebroadcast").child(intentuid).setValue(user);
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}
