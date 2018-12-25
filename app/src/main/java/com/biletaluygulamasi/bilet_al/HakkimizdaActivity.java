package com.biletaluygulamasi.bilet_al;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HakkimizdaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimizda);


        getSupportActionBar().setTitle("Hakkımızda");
        Intent ıntentt = getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}
