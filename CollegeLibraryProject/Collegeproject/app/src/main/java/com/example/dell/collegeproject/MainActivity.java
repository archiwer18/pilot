package com.example.dell.collegeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button b1;
    Button b2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);



    }
    public void sign(View v)
    {
        Intent it=new Intent(MainActivity.this,Account.class);

        startActivity(it);


    }
    public void login(View v)
    {
        Intent it=new Intent(MainActivity.this,loginid.class);

        startActivity(it);


    }


}
