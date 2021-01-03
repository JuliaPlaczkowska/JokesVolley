package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleRequestClick(View view) {

        Intent intent = new Intent(this, SimpleRequestActivity.class);
        startActivity(intent);

    }

    public void jsonRequestClick(View view) {
        Intent intent = new Intent(this, JsonActivity.class);
        startActivity(intent);
    }
}