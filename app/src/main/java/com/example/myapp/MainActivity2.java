package com.example.myapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button DECONNECTER;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DECONNECTER= findViewById(R.id.DECONNECTER);
        DECONNECTER.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentL = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(intentL);
                finish();
                Toast.makeText(MainActivity2.this, "successfully Logout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}