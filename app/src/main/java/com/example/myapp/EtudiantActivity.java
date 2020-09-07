package com.example.myapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EtudiantActivity extends AppCompatActivity {
    Button DECONNECTER;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_etudiant);
            DECONNECTER=findViewById(R.id.DECONNECTER);
            DECONNECTER.setOnClickListener(new View.OnContextClickListener(){
                @Override
                public boolean onContextClick(View view) {
                    Intent intentL=new Intent(EtudiantActivity.this,EtudiantActivity.class);
                    startActivity(intentL);
                    finish();
                    Toast.makeText(EtudiantActivity.this, "successfully Logout",Toast.LENGTH_SHORT).show();
                }
            });
    }
}