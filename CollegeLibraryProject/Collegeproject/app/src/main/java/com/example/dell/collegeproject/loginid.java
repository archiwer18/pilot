package com.example.dell.collegeproject;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class loginid extends AppCompatActivity  {
    EditText et1,et2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginid);
        et1= (EditText) findViewById(R.id.editText6);
        et2= (EditText) findViewById(R.id.editText7);
        btn= (Button) findViewById(R.id.button4);


    }
public void login(View v)
{
    Intent it= new Intent(loginid.this,teacherid.class);
    startActivity(it);
}
}




