package com.example.preferenceapplication;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import java.util.prefs.PreferencesFactory;

public class PrFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}
