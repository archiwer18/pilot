package com.example.dell.collegeproject;

import android.app.ActionBar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class teacheriddetail extends AppCompatActivity implements ActionBar.TabListener,ViewPager.OnPageChangeListener, android.support.v7.app.ActionBar.TabListener {
    FragmentPagerAdapter fp;
    ViewPager vp;
    //android.support.v7.app.
    ActionBar ab;
    Adapter ad;
    String[] st={"Books","Issued"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_id_detail);
        vp= (ViewPager) findViewById(R.id.pager);
        ab=getActionBar();
        ad=new Adapter(getSupportFragmentManager());
        vp.setAdapter(ad);
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for(String a:st){
            ab.addTab(ab.newTab().setText(a).setTabListener(this));

        }
        vp.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        getSupportActionBar().setSelectedNavigationItem(i);
    }



    @Override
    public void onPageScrollStateChanged(int i) {

    }



    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        vp.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}


