package com.bignerdranch.android.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends Activity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.settings);

            Spinner mySpinner;
            mySpinner = (Spinner) findViewById(R.id.spinner);

            List<String> list = new ArrayList<String>();
            list.add("Romania");
            list.add("Mexico");
            list.add("Germany");
            list.add("United Kingdom");
            ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, R.layout.spinner_item, list);
            mySpinner.setAdapter(dataAdapter);
        }
    }
