package com.example.dell.collegelibraryproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DELL on 02-Nov-15.
 */
public class CustomMagazinesAdapter extends ArrayAdapter {
    Context con;

    String arr_name1[];
    String arr_no1[];
    Integer arr_image1[];

    public CustomMagazinesAdapter(Context context,String arr_name[],String arr_no[],Integer arr_image[]) {
        super(context, R.layout.custom_magazine_adapter_xml,arr_name);

        con = context;
        arr_name1 = arr_name;
        arr_no1 = arr_no;
        arr_image1 = arr_image;
    }



    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater myinflate = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = myinflate.inflate(R.layout.custom_magazine_adapter_xml, null, true);
        TextView tvname = (TextView) convertView.findViewById(R.id.textView);
        TextView tvno = (TextView) convertView.findViewById(R.id.textView2);
        ImageView imgage = (ImageView) convertView.findViewById(R.id.imageView);
        tvname.setText(arr_name1[position]);
        tvno.setText(arr_no1[position]);
        imgage.setImageResource(arr_image1[position]);

        return convertView;
    }
}


