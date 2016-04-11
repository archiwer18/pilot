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

public class first extends AppCompatActivity {
    Button b1, b2;
    TextView tv;
    Intent it;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        tv = (TextView) findViewById(R.id.textView);
    }

    public void login(View v) {
        it = new Intent(first.this, login1.class);
        startActivity(it);

    }

    public void signin(View v) {
        it = new Intent(first.this, signin.class);
        startActivity(it);

    }

    }




