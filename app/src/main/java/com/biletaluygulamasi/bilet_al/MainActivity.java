package com.biletaluygulamasi.bilet_al;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



SharedPreferences veri;
    public String nereden;
    public String nereye;
    public EditText tarih;
    private Button sefer_arama;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    int year_x,month_x,day_x;
    static final int DILOG_ID=0;
    private static final String TAG="MainActivity";
    Spinner spinner1;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent splash_intent = getIntent();


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_kalkis);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_varis);
        String sehirler_kalkis[] = getResources().getStringArray(R.array.sehirler_kalkis);
        String sehirler_varis[] = getResources().getStringArray(R.array.sehirler_varis);

         ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,sehirler_kalkis);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,sehirler_varis);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ss = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), ss ,Toast.LENGTH_SHORT).show();
                nereden = ss;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String ss = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), ss ,Toast.LENGTH_SHORT).show();
                nereye=ss;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sefer_arama= (Button)findViewById(R.id.button_arama);
        tarih = (EditText)findViewById(R.id.tarih_Sec);
        tarih.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                year_x = cal.get(Calendar.YEAR);
                month_x = cal.get(Calendar.MONTH);
                day_x = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDataSetListener,year_x,month_x,day_x);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year_x, int month_x, int day_x) {
                month_x=month_x+1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy : " +month_x+"/"+day_x+"/"+year_x);
                String date = day_x+"/"+month_x+"/"+year_x;
                tarih.setText(date);
            }
        };



        sefer_arama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homeIntent = new Intent(MainActivity.this , seferler.class);

                homeIntent.putExtra("tarih",tarih.getText().toString());
                homeIntent.putExtra("nereden",nereden);
                homeIntent.putExtra("nereye",nereye);
                startActivity(homeIntent);
                finish();


            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.otobus_bilet) {

            fragmentManager.beginTransaction().replace(R.id.content_frame,new fragment_otobus()).commit();
            tarih.setText("");

        } else if (id == R.id.biletlerim) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new fragment_bilet()).commit();



        } else if (id == R.id.hakkimizda) {

            Intent ıntentt = new Intent(MainActivity.this,HakkimizdaActivity.class);
            startActivity(ıntentt);


        } else if (id == R.id.iletisim) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new fragment_iletisim()).commit();
            Intent ıntent_iletisim = new Intent(MainActivity.this,IletisimActivity.class);
            startActivity(ıntent_iletisim);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






}
