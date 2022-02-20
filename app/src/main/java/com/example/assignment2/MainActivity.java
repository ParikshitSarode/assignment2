package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
    boolean connected = false;
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

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;

        startser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                }
                else
                    connected = false;


                if(connected){
                    Toast.makeText(MainActivity.this, "Service running", Toast.LENGTH_SHORT).show();
                Nav.setVisibility(View.VISIBLE);
                //start service to get news
                startService(new Intent(getBaseContext(),MyService.class));
            }
                else{
                    Toast.makeText(MainActivity.this, "Network not available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        stopser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

            if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                //we are connected to a network
                connected = true;
            }
                else
            connected = false;


                if(connected){
                if (Nav.getVisibility()==View.INVISIBLE)
                    Toast.makeText(MainActivity.this, "Service Not running", Toast.LENGTH_SHORT).show();
                else if (Nav.getVisibility()==View.VISIBLE)
                    Toast.makeText(MainActivity.this, "Service stopped", Toast.LENGTH_SHORT).show();
                Nav.setVisibility(View.VISIBLE);
                //start service to get news
                startService(new Intent(getBaseContext(),MyService.class));
            }
                else{
                Toast.makeText(MainActivity.this, "Network not available", Toast.LENGTH_SHORT).show();
            }
        }
    });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                }
                else
                    connected = false;

                //goto prev news and update counter view
                if(countervalue>1&&connected){
                    countervalue--;
                    counter.setText(countervalue+"/"+total);
                }
                else if(!connected)
                    Toast.makeText(MainActivity.this, "Network not available", Toast.LENGTH_SHORT).show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                }
                else
                    connected = false;

                if(countervalue<total&&connected){
                    countervalue++;
                    counter.setText(countervalue+"/"+total);
                }
                else if(!connected)
                    Toast.makeText(MainActivity.this, "Network not available", Toast.LENGTH_SHORT).show();
            }
        });

    }



}