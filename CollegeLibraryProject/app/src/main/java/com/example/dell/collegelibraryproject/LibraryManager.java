package com.example.dell.collegelibraryproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LibraryManager extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
    FragmentPagerAdapter fpg;
    ViewPager vp;
    android.support.v7.app.ActionBar ab;
    adapter ad;
    String[] ar={"home","Books","notification"};
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabdetail);
        vp= (ViewPager) findViewById(R.id.pager);

        ab= getSupportActionBar();
        ad= new adapter(getSupportFragmentManager());
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a53ff")));
        ab.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a53ff")));

        vp.setAdapter(ad);

        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for( String tame: ar) {
            ab.addTab(ab.newTab().setText(tame).setTabListener(this));
        }
        vp.setOnPageChangeListener(this);




    }



    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        getSupportActionBar().setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}


