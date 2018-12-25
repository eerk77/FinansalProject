package com.biletaluygulamasi.bilet_al;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Myquery {

private static Myquery myquery;
private RequestQueue requestQueue;
private static Context mycontext;


private Myquery(Context context)
{
    mycontext = context;
    requestQueue = getRequestQueue();
}



    public RequestQueue getRequestQueue() {
        if(requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(mycontext.getApplicationContext());

        }
        return requestQueue;
    }


    public static synchronized Myquery getMyquery(Context context)

    {
            if(myquery ==null)
            {
                myquery = new Myquery(context);
            }
return myquery;
    }

        public<T> void addToRequest(Request<T> request)
        {
            requestQueue.add(request);
        }

}
