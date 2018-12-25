package com.biletaluygulamasi.bilet_al;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class KoltukSecimActivity extends AppCompatActivity implements View.OnClickListener {


    TextView textView_int;
    TextView textView_saat_int;
    Button btn1,btn2,btn3,btn_dvm,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,
            btn20,btn21,btn22,btn23,btn24,btn25,btn26;
    CheckBox erkek_secim;
    CheckBox kadin_secim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koltuk_secim);
        textView_int = findViewById(R.id.textView_int);
        textView_saat_int = findViewById(R.id.textView_Saat);

        erkek_secim = findViewById(R.id.checkBox);
        kadin_secim = findViewById(R.id.checkBox2);


        btn1 = findViewById(R.id.f1);btn2 = findViewById(R.id.f2);btn3 = findViewById(R.id.f3);btn4 = findViewById(R.id.f4);
        btn5 = findViewById(R.id.f5);btn6 = findViewById(R.id.f6);btn7 = findViewById(R.id.f7);btn8 = findViewById(R.id.f8);
        btn9 = findViewById(R.id.f9);btn10 = findViewById(R.id.f10);btn11 = findViewById(R.id.f11);btn12 = findViewById(R.id.f12);
        btn13 = findViewById(R.id.f13);btn14 = findViewById(R.id.f14);btn15 = findViewById(R.id.f15);btn16 = findViewById(R.id.f16);
        btn17 = findViewById(R.id.f17);btn18 = findViewById(R.id.f18);btn19 = findViewById(R.id.f19);btn20 = findViewById(R.id.f20);
        btn21 = findViewById(R.id.f21);btn22 = findViewById(R.id.f22);btn23 = findViewById(R.id.f23);btn24 = findViewById(R.id.f24);
        btn25 = findViewById(R.id.f25);btn26 = findViewById(R.id.f26);

        btn_dvm = findViewById(R.id.button_devam);


        btn1.setOnClickListener(this);btn2.setOnClickListener(this);btn3.setOnClickListener(this);btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);btn6.setOnClickListener(this);btn7.setOnClickListener(this);btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);btn10.setOnClickListener(this);btn11.setOnClickListener(this);btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);btn14.setOnClickListener(this);btn15.setOnClickListener(this);btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);btn18.setOnClickListener(this);btn19.setOnClickListener(this);btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);btn22.setOnClickListener(this);btn23.setOnClickListener(this);btn24.setOnClickListener(this);
        btn25.setOnClickListener(this);btn26.setOnClickListener(this);


        Intent ıntent3 = this.getIntent();
        Bundle bundle = getIntent().getExtras();
        String name_fiyat = ıntent3.getExtras().getString("fiyat");
        String name_saat = ıntent3.getExtras().getString("saat");


        textView_int.setText(name_fiyat);
        textView_saat_int.setText(name_saat);


        btn_dvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntentbilgi = new Intent(KoltukSecimActivity.this,Bilgileri_Gonder.class);
                ıntentbilgi.putExtra("fiyati",textView_int.getText());
                ıntentbilgi.putExtra("saati",textView_saat_int.getText());
                startActivity(ıntentbilgi);


            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.f1:
              if(btn1.isSelected())
             {
                 break;
             }
                 if(erkek_secim.isChecked()) {
                    btn1.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn1.setBackgroundResource(R.drawable.kadin);
                }

                break;
            case R.id.f2:
                if(erkek_secim.isChecked()) {
                    btn2.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn2.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f3:
                if(erkek_secim.isChecked()) {
                    btn3.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn3.setBackgroundResource(R.drawable.kadin);
                }

                break;
            case R.id.f4:
                if(erkek_secim.isChecked()) {
                    btn4.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn4.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f5:
                if(erkek_secim.isChecked()) {
                    btn5.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn5.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f6:
                if(erkek_secim.isChecked()) {
                    btn6.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn6.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f7:
                if(erkek_secim.isChecked()) {
                    btn7.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn7.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f8:
                if(erkek_secim.isChecked()) {
                    btn8.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn8.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f9:
                if(erkek_secim.isChecked()) {
                    btn9.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn9.setBackgroundResource(R.drawable.kadin);
                }

                break;
            case R.id.f10:
                if(erkek_secim.isChecked()) {
                    btn10.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn10.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f11:
                if(erkek_secim.isChecked()) {
                    btn11.setBackgroundResource(R.drawable.erkek);
                }
                else if (kadin_secim.isChecked()){
                    btn11.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f12:
                if(erkek_secim.isChecked()) {
                    btn12.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn12.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f13:
                if(erkek_secim.isChecked()) {
                    btn13.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn13.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f14:
                if(erkek_secim.isChecked()) {
                    btn14.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn14.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f15:
                if(erkek_secim.isChecked()) {
                    btn15.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn15.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f16:
                if(erkek_secim.isChecked()) {
                    btn16.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn16.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f17:
                if(erkek_secim.isChecked()) {
                    btn17.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn17.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f18:
                if(erkek_secim.isChecked()) {
                    btn18.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn18.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f19:
                if(erkek_secim.isChecked()) {
                    btn19.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn19.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f20:
                if(erkek_secim.isChecked()) {
                    btn20.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn20.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f21:
                if(erkek_secim.isChecked()) {
                    btn21.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn21.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f22:
                if(erkek_secim.isChecked()) {
                    btn22.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn22.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f23:
                if(erkek_secim.isChecked()) {
                    btn23.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn23.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f24:
                if(erkek_secim.isChecked()) {
                    btn24.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn24.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f25:
                if(erkek_secim.isChecked()) {
                    btn25.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn25.setBackgroundResource(R.drawable.kadin);
                }
                break;
            case R.id.f26:
                if(erkek_secim.isChecked()) {
                    btn26.setBackgroundResource(R.drawable.erkek);
                }
                else {
                    btn26.setBackgroundResource(R.drawable.kadin);
                }
                break;


        }

    }
}

