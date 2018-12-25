package com.biletaluygulamasi.bilet_al;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class seferler extends AppCompatActivity {

    static String Nereden;
    static String Nereye;

    private static final String url_data ="http://tek-stilambalaj.com/deneme.php";
    private static final String url ="http://tek-stilambalaj.com/istemci.php";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<list_item> list_items;

    private TextView nrdn;
    private TextView nry;

    private String datem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seferler);


        Intent homeIntent = getIntent();

        datem = homeIntent.getStringExtra("tarih");
        Nereden = homeIntent.getStringExtra("nereden");
        Nereye = homeIntent.getStringExtra("nereye");


        nrdn = findViewById(R.id.textVnereden);
        nry= findViewById(R.id.textVnereye);
        nrdn.setText(Nereden);
        nry.setText(Nereye);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


     SharedPreferences sharedPref = getSharedPreferences("info", Context.MODE_PRIVATE);
     SharedPreferences.Editor editor = sharedPref.edit();
     editor.putString("kalkis",nrdn.getText().toString());
     editor.putString("varis",nry.getText().toString());
     editor.commit();



        /*JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    nrdn.setText(response.getString("Nereden"));
                    nry.setText(response.getString("Nereye"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(seferler.this, "wrong", Toast.LENGTH_SHORT).show();

            }
        }
        );

        Myquery.getMyquery(seferler.this).addToRequest(jsonObjectRequest);

       /*/


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list_items = new ArrayList<>();

        loadRecyclerViewData();

        }


        private void loadRecyclerViewData(){

            final ProgressDialog progressDialog =new ProgressDialog(this);
            progressDialog.setMessage("Loading data");
            progressDialog.show();

            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    url_data, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    progressDialog.dismiss();
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray array = jsonObject.getJSONArray("seferler");

                        for (int i=0; i<array.length(); i++){

                            JSONObject o = array.getJSONObject(i);
                            if(datem.equals(o.getString("tarih")) && Nereden.equals(o.getString("nereden"))&&Nereye.equals(o.getString("nereye"))) {
                                list_item item = new list_item(

                                        o.getString("saat"),
                                        o.getString("fiyat"),
                                        o.getString("resim")
                                );

                                list_items.add(item);

                            }
                        }




                        adapter = new myAdapter(list_items,getApplicationContext());
                        recyclerView.setAdapter(adapter);



                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();


                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);


        }
}

