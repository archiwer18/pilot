package com.example.dell.collegeproject;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DELL on 24-Oct-15.
 */
public class Adapter extends FragmentPagerAdapter {
    public Adapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i)
        {
            case 0:
                return new Books();
            case 1:
                return new Issued();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

