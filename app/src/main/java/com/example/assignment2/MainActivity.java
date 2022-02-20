package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    LinearLayout Nav;
    TextView counter;
    Button startser,stopser,prev,next;
    int countervalue = 1, total = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nav = (LinearLayout) findViewById(R.id.nav);
        startser = (Button) findViewById(R.id.button);
        stopser = (Button) findViewById(R.id.button2);
        counter = (TextView) findViewById(R.id.textView4);
        prev =  (Button) findViewById(R.id.button3);
        next  =  (Button) findViewById(R.id.button4);
        Nav.setVisibility(View.INVISIBLE);

        startser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Nav.getVisibility()==View.INVISIBLE)
                Toast.makeText(MainActivity.this, "Service Started", Toast.LENGTH_SHORT).show();
                else if (Nav.getVisibility()==View.VISIBLE)
                    Toast.makeText(MainActivity.this, "Service already running", Toast.LENGTH_SHORT).show();
                Nav.setVisibility(View.VISIBLE);
                //start service to get news
            }
        });

        stopser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop service
                Toast.makeText(MainActivity.this, "Service Stopped", Toast.LENGTH_SHORT).show();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //goto prev news and update counter view
                if(countervalue>1){
                    countervalue--;
                    counter.setText(countervalue+"/"+total);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countervalue<total){
                    countervalue++;
                    counter.setText(countervalue+"/"+total);
                }
            }
        });

    }



}