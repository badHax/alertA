package com.example.odain.alertapp.models;

/**
 * Created by odain on 5/17/2017.
 */

import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

public class AlertClientUsage {

    JSONObject firstEvent = null;
    String alertResp;

        public void sendAlert() {
            AlertClient.get("statuses/public_timeline.json", null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                    try {
                        firstEvent = (JSONObject) timeline.get(0);
                        alertResp = firstEvent.getString("text");

                        // Do something with the response
                        System.out.println(alertResp);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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
