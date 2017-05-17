package com.example.odain.alertapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.odain.alertapp.R;
import com.example.odain.alertapp.activities.AlertActivity;
import com.example.odain.alertapp.activities.MainActivity;

/**
 * Created by odain on 5/15/2017.
 */

public class AlertFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    @Nullable
    Button alertBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View tabView = inflater.inflate(R.layout.tab_fragment_alert, container, false);
        alertBtn = (Button) tabView.findViewById(R.id.alert_button);
        alertBtn.setOnClickListener(this);
        return tabView;
    }

    @Override
    public void onClick(View v) {
        Intent alertActivity = new Intent();
        alertActivity.setClass(v.getContext(),AlertActivity.class);
        startActivity(alertActivity);
    }
}
