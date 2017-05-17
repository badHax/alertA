package com.example.odain.alertapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.odain.alertapp.fragments.AlertFragment;
import com.example.odain.alertapp.fragments.RecordFragment;
import com.example.odain.alertapp.fragments.ReportFragment;

/**
 * Created by odain on 5/16/2017.
 */



public class TabAdapter extends FragmentStatePagerAdapter {

    int NUM_TABS;

    public TabAdapter(FragmentManager fm) {
        super(fm);
        this.NUM_TABS = 3;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:{
                AlertFragment frag1 = new AlertFragment();
                return frag1;
            }
            case 1:{
                RecordFragment frag2 = new RecordFragment();
                return frag2;
            }
            case 2:{
                ReportFragment frag3 = new ReportFragment();
                return  frag3;
            }
        default:
            return null;
        }
    }

    @Override
    public int getCount() {
        return this.NUM_TABS;
    }
}
