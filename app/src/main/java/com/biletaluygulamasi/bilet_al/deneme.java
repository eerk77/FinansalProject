package com.biletaluygulamasi.bilet_al;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//import com.android.volley.Response;

public class deneme extends AppCompatActivity {



    private ListView mUserList;
    private TextView ad;
    private TextView nereden;
    private TextView nereye;
    private Button btnGoster;
    ProgressDialog dialog;

    String url = "http://infinitcoding.club/istemci.php";

    private ArrayList<String> mUserNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);


        ad = findViewById(R.id.textView24);
        nereden = findViewById(R.id.textView25);
        nereye = findViewById(R.id.textView26);
        btnGoster = findViewById(R.id.btn3);



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    
                     ad.setText(response.getString("Ad"));
                    nereden.setText(response.getString("Nereden"));
                    nereye.setText(response.getString("Nereye"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(deneme.this, "wrong", Toast.LENGTH_SHORT).show();

            }
        }
        );

        Myquery.getMyquery(deneme.this).addToRequest(jsonObjectRequest);

 /*
                dialog = new ProgressDialog(deneme.this);
                dialog.setMessage("Loading....");
                dialog.show();

                StringRequest request = new StringRequest(url, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String string) {
                        parseJsonData(string);
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                RequestQueue rQueue = Volley.newRequestQueue(deneme.this);
                rQueue.add(request);











        mDatabase = FirebaseDatabase.getInstance().getReference("sefer");
        mDatabase = FirebaseDatabase.getInstance().getReference("1");


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUserNames);
        mUserList.setAdapter(arrayAdapter);
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                mUserNames.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray kayitlar = object.getJSONArray("islem");
            ArrayList al = new ArrayList();

            for(int i = 0; i < kayitlar.length(); ++i) {
                al.add(kayitlar.getString(i));
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
            mUserList.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }
 */
    }

}