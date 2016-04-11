package com.example.dell.collegelibraryproject;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;

/**
 * Created by DELL on 01-Nov-15.
 */
public class Notification extends Fragment  {
    DatePicker dp;
    TextView tv1,tv2;

    Context context=null;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v4 = inflater.inflate(R.layout.notification, container, false);
        tv1= (TextView) v4.findViewById(R.id.textView5);
        tv2= (TextView) v4.findViewById(R.id.textView9);
        dp= (DatePicker) v4.findViewById(R.id.datePicker);



        return v4;
    }



           //startAlert();


    /*public void startAlert() {
        //Context context;


        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(getActivity(), MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getActivity(),0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) (getActivity().getSystemService(Context.ALARM_SERVICE));
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000*60*60*24*15), pendingIntent);
        Toast.makeText(getActivity(), "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();
    }*/

    }