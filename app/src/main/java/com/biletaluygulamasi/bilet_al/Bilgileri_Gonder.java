package com.biletaluygulamasi.bilet_al;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bilgileri_Gonder extends AppCompatActivity {


    private EditText kime;
    private EditText konu;
    private  EditText tc_no;
    private EditText mesaj;
    private TextView txt_nreden;
    private TextView txt_nreye;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgileri__gonder);

        SharedPreferences sharedPref = getSharedPreferences("info", Context.MODE_PRIVATE);
       final String Nereden = sharedPref.getString("kalkis","");
       final String Nereye = sharedPref.getString("varis","");

        Intent ıntentbilgi = getIntent();
        final String name_fiyat = ıntentbilgi.getExtras().getString("fiyati");
        final String name_saat = ıntentbilgi.getExtras().getString("saati");


        final String hitap = "Sayın ";
        final String info = " Bilet bilgileriniz aşağıdaki gibidir. \n";

        kime = findViewById(R.id.editText_kime);
        konu = findViewById(R.id.editText2_konu);
        tc_no = findViewById(R.id.editText_tc);

        Button buttonsend = findViewById(R.id.gonder);
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mail_Adres = kime.getText().toString();
                String [] adres_list = new String[100];
                adres_list[0] = konu.getText().toString();
                String konu_mail = konu.getText().toString();
                String tc = tc_no.getText().toString();
                String mesaj_mail = hitap + mail_Adres +".\n"+"Tc No :"+ tc +" "+ info + Nereden + "-" + Nereye + " \n"+"Fiyat " + name_fiyat + " Saat " + name_saat
                      +"\n"  +"İyi Yolculuklar... ";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,adres_list);
                email.putExtra(Intent.EXTRA_SUBJECT,"Bilet Satis");
                email.putExtra(Intent.EXTRA_TEXT,mesaj_mail);

                email.setType("message/rfc822");
                startActivity(email);
            }
        });



    }


























}
