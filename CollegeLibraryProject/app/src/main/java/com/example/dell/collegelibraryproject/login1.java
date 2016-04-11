package com.example.dell.collegelibraryproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class login1 extends AppCompatActivity {
    EditText et1, et2;
    Button log,can;
    TextView tx1;
    String username,password;
    InputStream inputStream;
    String myresult,result;
    Intent intent;
    int i;
    int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        //ActionBar actionBar=getSupportActionBar();
        //actionBar.hide();
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        tx1 = (TextView) findViewById(R.id.textView3);

        tx1.setVisibility(View.GONE);

        log = (Button) findViewById(R.id.button);
        can = (Button) findViewById(R.id.button2);
        //username=et1.toString();
        //password=et2.toString();


        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                 username = et1.getText().toString();
                 password = et2.getText().toString();
                if (username.equals("") || password.equals("")) {

                    Toast.makeText(login1.this, "Username or password must be filled", Toast.LENGTH_LONG).show();

                    return;

                }

                if (username.length() <= 1 || password.length() <= 1) {
                    Toast.makeText(login1.this, "Username or password length must be greater than one", Toast.LENGTH_LONG).show();
                    return;

                }



                new Mydata().execute();

            }

        });


        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

     public class Mydata extends AsyncTask<String, String, String> {



          @Override
          protected void onPreExecute() {
              super.onPreExecute();
              //username=et1.getText().toString();
              //password=et2.getText().toString();
          }


            @Override
            protected String doInBackground(String... params) {

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://lib.poetshub.website/and_index.php");
                List<NameValuePair> lst = new ArrayList<NameValuePair>();
                lst.add(new BasicNameValuePair("user", username));
                lst.add(new BasicNameValuePair("pass", password));

                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(lst));

                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    inputStream = httpEntity.getContent();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);

                    }
                    myresult = stringBuilder.toString();


                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                if (myresult != null) {

                    try {
                        JSONArray jsonArray = new JSONArray(myresult);
                        for (i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            result = jsonObject.getString("check");
                            //result1=jsonObject.getString("book_publication");

                            //arrayList.add(result);


                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                return null;
            }



          @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
              int num = 0;

              try {
                  num = Integer.parseInt(result);
              } catch(NumberFormatException nfe) {

              }

              //int var=Integer.parseInt(result);

              //tv.setText(var);

              if(num==0)
              {
                  Toast.makeText(login1.this, "welcome in library app", Toast.LENGTH_SHORT).show();
                  intent= new Intent(login1.this,LibraryManager.class);
                  startActivity(intent);

              }
              else {
                  Toast.makeText(login1.this, "wrong username or password", Toast.LENGTH_SHORT).show();
                  tx1.setVisibility(View.VISIBLE);
                  //tx1.setBackgroundColor(Color.WHITE);
                  counter--;
                  tx1.setText(Integer.toString(counter));

                  if (counter == 0) {
                      log.setEnabled(false);
                  }
              }


              //textView.setThreshold(1);

                //lv.setAdapter(adapter);
                //tv1.setText(result);
                //tv3.setText(result1);

            }
        }

    }
