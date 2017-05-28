package com.example.odain.alertapp.models;

/**
 * Created by odain on 5/17/2017.
 */

import com.loopj.android.http.*;

public class AlertClient {
    private static final String BASE_URL = "http://blazeapp-ninjabreadfruit2.c9users.io:8080/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        try{
        client.get(getAbsoluteUrl(url), params, responseHandler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        try{
        client.post(getAbsoluteUrl(url), params, responseHandler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
