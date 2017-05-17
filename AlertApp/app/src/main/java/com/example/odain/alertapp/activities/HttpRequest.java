package com.example.odain.alertapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by odain on 5/16/2017.
 */

public class HttpRequest extends AppCompatActivity {
    URL url;
    String URL = "";
    HttpURLConnection urlConnection = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void Alert(){
        try{
            url = new URL("http://www.mysite.se/index.asp?data=99");
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                System.out.print(current);
                }
            } catch(Exception e)
            {
                e.printStackTrace();
            }
            finally

            {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }

        void setURL(String url){
            this.URL = url;
        }
}

