package com.example.anirudh.touristguide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Guide_Home_Screen extends AppCompatActivity {

    private DatabaseReference Database;
    FirebaseAuth auth;
    FirebaseUser user;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide__home__screen);
        Database = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        auth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information

                    user = auth.getCurrentUser();

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(Guide_Home_Screen.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }

                // ...
            }
        });
        try {
            uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        } catch (Exception e) {
        }

        try {
            ImageView tnsd_iv_qr = (ImageView) findViewById(R.id.imageView);


            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode(uid, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

            if (bitmap == null) {
                finish();
                Intent intent = new Intent(this,Guide_Home_Screen.class);
                startActivity(intent);
            }
            tnsd_iv_qr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        }
    }
    public void onclick(View view)
    {
        Intent intent=new Intent(this,GuideBroadcast.class);
        intent.putExtra("uid",uid);
        startActivity(intent);
    }
}
