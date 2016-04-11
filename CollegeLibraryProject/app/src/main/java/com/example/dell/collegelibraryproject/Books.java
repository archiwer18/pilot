package com.example.dell.collegelibraryproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by DELL on 01-Nov-15.
 */
public class Books extends Fragment implements View.OnClickListener {

    AutoCompleteTextView tv2, tv3;
    // TextView tv;

    fatch ft;
    String bookname, branch, semester;
    //fetcher ft;
    String s, result;

    Button b;

    int i;
    ArrayList<String> arrayList, arrayList1, arrayList2;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter, adapter1, adapter2;

    Button search;

    // Button findbook, search;
    //Spinner branch, semester;

    // Context context;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v4 = inflater.inflate(R.layout.books, container, false);

        //findbook = (Button) v4.findViewById(R.id.button7);
        //findbook.setOnClickListener(this);

        //tv= (TextView) v4.findViewById(R.id.textView10);


        //branch = (Spinner) v4.findViewById(R.id.spinner);
        //semester = (Spinner) v4.findViewById(R.id.spinner2);
        //tv2 = (AutoCompleteTextView) v4.findViewById(R.id.autoCompleteTextView2);
        //tv3 = (AutoCompleteTextView) v4.findViewById(R.id.autoCompleteTextView3);

        search = (Button) v4.findViewById(R.id.button6);
        //ft = new fetcher();
        ft = new fatch();
        search.setOnClickListener(this);
        arrayList = new ArrayList();
        //arrayList1 = new ArrayList();
        //arrayList2 = new ArrayList();

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayList);
       // adapter1 = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayList1);
        //adapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayList2);


        autoCompleteTextView = (AutoCompleteTextView) v4.findViewById(R.id.autoCompleteTextView);
        new parser().execute();

        /*tv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object ob = parent.getItemAtPosition(position);
                branch = ob.toString();
            }
        });


        tv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object ob = parent.getItemAtPosition(position);
                semester = ob.toString();
            }
        });*/
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object ob1 = parent.getItemAtPosition(position);
                bookname = ob1.toString();

            }
        });




        return v4;


    }



    public void onClick(View v) {
        /*if (R.id.button3 == v.getId()) {

            Intent intent = new Intent(getActivity(), Customlistview.class);
            startActivity(intent);
        }*/
        if (R.id.button6 == v.getId()) {

            Intent intent = new Intent(getActivity(), searchbook.class);
           // bookname = autoCompleteTextView.getText().toString();

            //Bundle bundle=new Bundle();
            //bundle.putString("put",bookname);

            intent.putExtra("k1",bookname);
            startActivity(intent);

        } else {
        }


    }

    public class parser extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {

            ft.run();
            if (ft.jada != null) {

                try {
                    JSONArray jsonArray = new JSONArray(ft.jada);
                    for (i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        result = jsonObject.getString("book_name");

                        arrayList.add(result);


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(String ss) {

            super.onPostExecute(s);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(adapter);
            //setting the adapter data into the AutoCompleteTextView
            //tv.setText(result);


        }

        public class branch0 extends AsyncTask<String, String, String> {


            @Override
            protected String doInBackground(String... params) {

                ft.run();
                if (ft.jada != null) {

                    try {
                        JSONArray jsonArray = new JSONArray(ft.jada);
                        for (i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            result = jsonObject.getString("bookname");
                            arrayList.add(result);


                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                return null;
            }
        }








    }

}



