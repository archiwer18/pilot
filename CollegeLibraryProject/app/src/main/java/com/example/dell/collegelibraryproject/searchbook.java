package com.example.dell.collegelibraryproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
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

public class searchbook extends AppCompatActivity {
    TextView textView, tv1,tv2,tv3,tv4;

    String myresult;
    InputStream inputStream;
    //ListView lv;
    //Button issue;
    String put;
    //int counter = 2;
    //fatch ft;
    //bookdetailclass bdc;


    String s, result,result1,result2;

    Button b;

    int i;
    ArrayList<String> arrayList;
    //AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter;
    String bookname1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchbook);
        textView = (TextView) findViewById(R.id.textView3);
        tv1 = (TextView) findViewById(R.id.textView10);
        //issue = (Button) findViewById(R.id.button8);

        Bundle bundle = getIntent().getExtras();
        bookname1 = bundle.getString("k1");

        tv2= (TextView) findViewById(R.id.textView11);
        tv3=(TextView) findViewById(R.id.textView12);
        //tv4= (TextView) findViewById(R.id.textView13);

                //bdc=new bookdetailclass();


        //issue.setOnClickListener(this);
        arrayList = new ArrayList();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        // lv= (ListView) findViewById(R.id.textView4);


        textView.setText(bookname1);
        //tv1.setText(bdc.myresult);
        new parser().execute();
        new abc().execute();
    }


   /* public void onClick(View v) {

        counter--;

        Toast.makeText(this, "book issued successfully", Toast.LENGTH_LONG).show();

        if (counter == 0) {
            issue.setEnabled(false);
        }

    }*/

    class parser extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://lib.poetshub.website/and_all_book.php");
            List<NameValuePair> lst = new ArrayList<NameValuePair>();
            lst.add(new BasicNameValuePair("book", bookname1));
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
                        result = jsonObject.getString("book_author");
                        result1=jsonObject.getString("book_publication");

                        arrayList.add(result);


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
            //textView.setThreshold(1);
            //lv.setAdapter(adapter);
            tv1.setText(result);
            tv3.setText(result1);

        }
    }


     public class abc extends AsyncTask<String, String, String> {


            @Override
            protected String doInBackground(String... params) {

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://lib.poetshub.website/and_all_book.php");
                List<NameValuePair> lst = new ArrayList<NameValuePair>();
                lst.add(new BasicNameValuePair("available", bookname1));
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
                            result = jsonObject.getString("book_details");
                            arrayList.add(result);


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
                //textView.setThreshold(1);
                //lv.setAdapter(adapter);
                tv2.setText(myresult);

            }


        }
    }

