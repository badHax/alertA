package com.example.odain.alertapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odain.alertapp.R;

/**
 * Created by odain on 5/15/2017.
 */

public class ReportFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View tabView = inflater.inflate(R.layout.tab_fragment_report, container, false);
        return tabView;
    }
}
