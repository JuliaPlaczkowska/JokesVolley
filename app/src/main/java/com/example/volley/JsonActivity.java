package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
    }

    public void onClick(View view) {
        final TextView textView = (TextView) findViewById(R.id.tvResponse);
        String url = "https://official-joke-api.appspot.com/random_joke";

        RequestQueue queue = Volley.newRequestQueue(this);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response ->
        {

            Joke joke = gson.fromJson(response, Joke.class);
            textView.setText(joke.toString());


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        }
        );
        queue.add(stringRequest);


    }


}