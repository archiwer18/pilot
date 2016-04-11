package com.example.dell.collegelibraryproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DELL on 01-Nov-15.
 */
public class adapter extends FragmentPagerAdapter {
    public adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
                    switch (position) {
                case 0:
                    return new home();

                case 1:
                    return new Books();


                case 2:
                    return new Notification();


            



            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
