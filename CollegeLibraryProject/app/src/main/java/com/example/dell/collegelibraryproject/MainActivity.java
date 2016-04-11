package com.example.dell.collegelibraryproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //ImageView logo;
    //TextView t1,t2,t3;
    Intent in;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        //logo=(ImageView) findViewById(R.id.imageView1);

        //t1=(TextView) findViewById(R.id.textView1);
       // t2=(TextView) findViewById(R.id.textView2);
       // t3=(TextView) findViewById(R.id.textView3);
        //t1.setTextColor(Color.WHITE);
       // t2.setTextColor(Color.WHITE);
       // t3.setTextColor(Color.WHITE);



        in = new Intent(MainActivity.this, first.class);

        new Handler().postDelayed(new Runnable(){

                @Override

                public void run() {

                    startActivity(in);

                    finish();
                }

            }, 5000);


    }
}