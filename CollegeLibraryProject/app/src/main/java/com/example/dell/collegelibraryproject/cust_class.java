package com.example.dell.collegelibraryproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by DELL on 02-Nov-15.
 */
public class cust_class extends ArrayAdapter {

    Context con;

    String arr_name1[];
    String arr_no1[];
    Integer arr_image1[];

    public cust_class(Context context, String arr_name[]) {
        super(context, R.layout.cust_xml, arr_name);
        con = context;
        arr_name1 = arr_name;
        // arr_no1 = arr_no;
        // arr_image1 = arr_image;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater myinflate = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = myinflate.inflate(R.layout.cust_xml, null, true);
        TextView tvname = (TextView) convertView.findViewById(R.id.textView8);

        tvname.setText(arr_name1[position]);

        return convertView;
    }
}

