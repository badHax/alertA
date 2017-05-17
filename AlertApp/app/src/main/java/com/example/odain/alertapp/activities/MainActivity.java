package com.example.odain.alertapp.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.odain.alertapp.R;

import com.example.odain.alertapp.fragments.*;

import com.example.odain.alertapp.adapters.TabAdapter;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstRunPreferences();

        if(!getFirstRun()){
            setID();
            setRunned();
        }


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Alert"));
        tabLayout.addTab(tabLayout.newTab().setText("Record"));
        tabLayout.addTab(tabLayout.newTab().setText("Report"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setClipToPadding(false);
        mViewPager.setPageMargin(12);
        mViewPager.setAdapter(tabAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout) );

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_alert) {
            return true;
        }
        if (id == R.id.action_report) {
            return true;
        }

        if (id == R.id.action_record) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * get if this is the first run
     *
     * @return returns true, if this is the first run
     */
    public boolean getFirstRun() {
        return mPrefs.getBoolean("firstRun", true);
    }

    /**
     * store the first run
     */
    public void setRunned() {
        SharedPreferences.Editor edit = mPrefs.edit();
        edit.putBoolean("firstRun", false);
        edit.commit();
    }

    /**
     * setting up preferences storage
     */
    public void firstRunPreferences() {
        Context mContext = this.getApplicationContext();
        mPrefs = mContext.getSharedPreferences("myAppPrefs", 0); //0 = mode private. only this app can read these preferences
    }

    private void setID() {
        SecureRandom random = new SecureRandom();
        SharedPreferences.Editor edit = mPrefs.edit();
        edit.putString("AppID", new BigInteger(130, random).toString(32));
        edit.commit();
    }
}