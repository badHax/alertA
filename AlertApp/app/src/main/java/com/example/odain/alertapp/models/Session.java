package com.example.odain.alertapp.models;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by odain on 5/18/2017.
 */

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = cntx.getSharedPreferences("AlertAppPrefs", Context.MODE_PRIVATE);
    }

    public void setID(String id) {
        prefs.edit().putString("ID", id).apply();
    }

    public String getID() {
        return prefs.getString("ID","Nothing");
    }

    public void setRan(boolean bool){
        prefs.edit().putBoolean("firstrun",bool).apply();
    }

    public Boolean getRan(){
        return prefs.getBoolean("firstrun",false);
    }
}