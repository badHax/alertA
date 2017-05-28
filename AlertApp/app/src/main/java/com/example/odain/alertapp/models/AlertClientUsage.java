package com.example.odain.alertapp.models;

/**
 * Created by odain on 5/17/2017.
 */

import android.util.Log;

import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

import static com.loopj.android.http.AsyncHttpClient.log;

public class AlertClientUsage {

    JSONObject firstEvent = null;
    String alertResp;

        public void sendAlert(RequestParams requestParams) {
            AlertClient.post("rest/alert", requestParams, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray
                    try {
                        alertResp = firstEvent.getString("text");

                        // Do something with the response
                        log.i("ReportActivity",alertResp);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                    try {
                        firstEvent = (JSONObject) timeline.get(0);
                        alertResp = firstEvent.getString("text");

                        // Do something with the response
                        log.i("Report Activity",alertResp);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    super.onFailure(statusCode, headers, responseString, throwable);
                    log.d("Response", "" + responseString);
                    Log.d("Failed: ", "" + statusCode);
                    Log.d("Error : ", "" + throwable);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }

            });


        }

        public String getAlertResp(){
            return this.alertResp;
        }

        public JSONObject getFirstEvent(){
            return this.firstEvent;
        }
    }
