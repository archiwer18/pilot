package com.example.dell.collegelibraryproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by DELL on 01-Nov-15.
 */
public class Magazines extends Fragment implements AdapterView.OnItemClickListener {
    String arr_name[] = {"Times Of India", "Ebook", "Hindustan Times", "Engineering", "Earth","Research"};
    String arr_no[] = {"Available", "Available", "Available", "Available", "Available","Available"};

    Integer arr_image[] = {R.drawable.toi, R.drawable.earth, R.drawable.hindustantime, R.drawable.engineering, R.drawable.earth,R.drawable.research};
    ListView lv;
    ArrayAdapter<String> adp;
    CustomMagazinesAdapter obj;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v2 = inflater.inflate(R.layout.magazines, container, false);

        lv = (ListView) v2.findViewById(R.id.listView);
        obj = new CustomMagazinesAdapter(getActivity(), arr_name,arr_no,arr_image);
        lv.setAdapter((ListAdapter) obj);
        lv.setOnItemClickListener(this);

        return v2;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

        int position = i;
        String itemvalue = (String) lv.getItemAtPosition(i);
        if (itemvalue == "Times Of India" || itemvalue == "Ebook" || itemvalue == "Hindustan Times" || itemvalue == "Engineering" || itemvalue == "Earth" || itemvalue == "Research" ) {
            Toast.makeText(getActivity(), "Book:" + itemvalue + " is selected", Toast.LENGTH_SHORT).show();

        }
    }
}
