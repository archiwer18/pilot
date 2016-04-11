package com.example.dell.collegeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

public class teacherid extends AppCompatActivity {
    Spinner sp1, sp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_id);
        sp1= (Spinner) findViewById(R.id.spinner3);
        sp2= (Spinner) findViewById(R.id.spinner4);
    }
}

