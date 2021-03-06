package com.example.ishmitaloona.firebasetry;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ishmitaloona on 07/10/2017.
 */

public class MySingleton {
    private static MySingleton mySingleton;
    private static Context context;
    private RequestQueue requestQueue;

    MySingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }


    private RequestQueue getRequestQueue() {

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mySingleton == null) {
            mySingleton = new MySingleton(context);
        }
        return mySingleton;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

}
