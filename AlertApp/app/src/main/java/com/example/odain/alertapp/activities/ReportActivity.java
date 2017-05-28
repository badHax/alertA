package com.example.odain.alertapp.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.odain.alertapp.R;
import com.example.odain.alertapp.models.Alert;
import com.example.odain.alertapp.models.AlertClientUsage;
import com.example.odain.alertapp.models.Session;
import com.example.odain.alertapp.services.GPSTracker;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;

import static com.loopj.android.http.AsyncHttpClient.log;

/**
 * Created by odain on 5/17/2017.
 */

public class ReportActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton r1,r2,r3,r4;
    EditText editText;
    ArrayList<String> items;
    Alert alert;
    AlertClientUsage alertClient;
    SharedPreferences mSharedPref;
    String stringLatitude, stringLongitude, details;
    JSONObject resp;
    Button submitAlertBtn;
    RequestParams params;
    Session session;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AlertTheme);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.red));
            getWindow().setStatusBarColor(getResources().getColor(R.color.red_dark));
        }
        setContentView(R.layout.tab_fragment_report);

        initViews();
        setUpViews();

        mSharedPref = getPreferences(MODE_PRIVATE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION
            }, 10);
        }

        GPSTracker gpsTracker = new GPSTracker(this);
        gpsTracker.getLatitude();
        gpsTracker.getLongitude();

        details = editText.getText().toString();

        if (gpsTracker.getIsGPSTrackingEnabled())
        {
            stringLatitude = String.valueOf(gpsTracker.latitude);
            stringLongitude = String.valueOf(gpsTracker.longitude);
        }

        }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    items.add("house");
                    break;
            case R.id.radioButton2:
                if (checked)
                    items.add("vehicle");
                    break;
            case R.id.radioButton3:
                if (checked)
                    items.add("person");
                    break;
            case R.id.radioButton4:
                if (checked)
                    items.add("bush");
                    break;
        }
    }

    void initViews(){
        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);

        editText = (EditText) findViewById(R.id.editText);

        submitAlertBtn = (Button) findViewById(R.id.submit_alert_btn);
    }

    void setUpViews(){
        onRadioButtonClicked(r1);
        onRadioButtonClicked(r2);
        onRadioButtonClicked(r3);
        onRadioButtonClicked(r4);

        submitAlertBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        details = editText.getText().toString();
        params = new RequestParams();
        session = new Session(getApplicationContext());
        alert= new Alert(session.getID(),stringLatitude,stringLongitude,items,details);
        params.put("id",session.getID());
        params.put("latitude",stringLatitude);
        params.put("longitude",stringLongitude);
        params.put("items",items);
        params.put("details",details);
        alertClient = new AlertClientUsage();

        try{
            alertClient.sendAlert(params);
            resp = alertClient.getFirstEvent();
            Toast toast = Toast.makeText(getApplicationContext(), "Alert Sent", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
