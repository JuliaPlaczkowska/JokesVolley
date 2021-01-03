package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SimpleRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_request);
    }

    public void onClick(View view) {

        final TextView textView = (TextView) findViewById(R.id.tvResponse);
        final EditText editText = (EditText) findViewById(R.id.edtSimpleRequest);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = editText.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response ->
        {
            textView.setText(response.substring(0,200));

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