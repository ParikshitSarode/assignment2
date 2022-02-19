package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    LinearLayout Nav;
    Button startser,stopser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nav = (LinearLayout) findViewById(R.id.nav);
        startser = (Button) findViewById(R.id.button);
        stopser = (Button) findViewById(R.id.button2);
        Nav.setVisibility(View.INVISIBLE);

        startser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nav.setVisibility(View.VISIBLE);

                //start service to get news
            }
        });

        stopser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop service
            }
        });

    }



}