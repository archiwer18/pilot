package com.example.dell.collegelibraryproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DELL on 18-Dec-15.
 */
public class home extends Fragment {

    Timer tm;
    int i = 0;
    ImageView im;
    Integer arr[] = {R.drawable.cl2, R.drawable.cl5, R.drawable.cl3,R.drawable.cl4,R.drawable.cl12,R.drawable.cl1,R.drawable.cl9,R.drawable.cl5};//, R.drawable.m4,R.drawable.m5, R.drawable.m6, R.drawable.m7, R.drawable.m1,R.drawable.m9, R.drawable.m10};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v4 = inflater.inflate(R.layout.home, container, false);


        im = (ImageView) v4.findViewById(R.id.imageView29);
        // img.setImageResource(R.drawable.im22);
        tm = new Timer();


        tm.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {

                    @Override

                    public void run() {
                        if (i >7) {
                            i = 0;
                            im.setImageResource(arr[i]);
                        } else

                            im.setImageResource(arr[i]);
                        i++;

                    }


                });


            }
        }, 100, 5000);


        return v4;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tm.cancel();
        tm.purge();
    }

}








