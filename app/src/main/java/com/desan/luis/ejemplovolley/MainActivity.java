package com.desan.luis.ejemplovolley;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements Response.Listener<JSONArray>,Response.ErrorListener{
    @BindView(R.id.text)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //textView=(TextView)findViewById(R.id.text);
        com.android.volley.RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(Request.Method.GET,"http://samples.openweathermap.org/data/2.5/forecast/daily?q=M%C3%BCnchen,DE&appid=b1b15e88fa797225412429c1c50c122a1",null,this,this);
        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public void onResponse(JSONArray response) {
        Log.i("datos-->",response.toString());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.i("datos-->",error.getMessage());

    }
}
