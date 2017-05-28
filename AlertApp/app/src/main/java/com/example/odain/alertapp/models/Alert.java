package com.example.odain.alertapp.models;

import java.util.ArrayList;

/**
 * Created by odain on 5/16/2017.
 */

public class Alert {

    private String id;
    private String latitude;
    private String longitude;
    private String details;
    private ArrayList<String> burningItems;

    public Alert(String id, String lat, String lng, ArrayList<String> whats_burning,String details){
        this.id = id;
        this.latitude = lat;
        this.longitude = lng;
        this.burningItems = whats_burning;
        this.details = details;

    }

    public String getId(){
        return this.id;
    }

    public ArrayList<String> getBurningItems() {
        return burningItems;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    public String getDetails(){
        return this.details;
    }
}
