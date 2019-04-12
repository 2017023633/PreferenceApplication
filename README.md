# PreferenceApplication  
### 使用PrefereceFragment实现设置页面  
#### 主要代码：  
#### preference.xml  
```
<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
    <PreferenceCategory android:title="ln-line preference">
        <CheckBoxPreference
            android:key="checkBox"
            android:title="CheckBox Preference"
            android:summary="this is a checkbox">
        </CheckBoxPreference>
    </PreferenceCategory>
    <PreferenceCategory android:title="Dialog-based preferences">
        <EditTextPreference
            android:dialogTitle="Enter your favorite animal"
            android:key="editText"
            android:title="Edit text preference"
            android:summary="An example that uses an edit text dialog">
        </EditTextPreference>
        <ListPreference
            android:key="list"
            android:title="List preference"
            android:summary="An example that uses a list dialog"
            android:dialogTitle="Choose one"
            android:entries="@array/list"
            android:entryValues="@array/list">
        </ListPreference>
    </PreferenceCategory>
    <PreferenceCategory android:title="Launch preference">
        <PreferenceScreen
            android:key="screen"
            android:title="Screen Preference"
            android:summary="Shows another screen of preference">
            <CheckBoxPreference
                android:key="another_checkBox"
                android:title="Toggle Preference"
                android:summary="Preference that is on the next screen but same hierarchy">
            </CheckBoxPreference>
        </PreferenceScreen>
        <PreferenceScreen
            android:title="Intent preference"
            android:summary="Launches an Activity from an Intent">
        <intent
            android:action="android.intent.action.VIEW"
            android:data="https://www.baidu.com">
        </intent>
        </PreferenceScreen>
    </PreferenceCategory>
    <PreferenceCategory android:title="Preference attributes">
        <CheckBoxPreference
            android:key="parent_checkBox"
            android:title="Parent checkBox preference"
            android:summary="This is visually a parent">
        </CheckBoxPreference>
        <CheckBoxPreference
            android:dependency="parent_checkBox"
            android:key="child_checkBox"
            android:title="Child checkBox preference"
            android:summary="This is visually a child">
        </CheckBoxPreference>
    </PreferenceCategory>
</PreferenceScreen>  
```
#### strings.xml  
```
<resources>
    <string name="app_name">Preference Application</string>
    <string-array name="list">
        <item>Alpha Option 01</item>
        <item>Beta Option 02</item>
        <item>Charlie Option 03</item>
    </string-array>
</resources>
```  
#### PrFragment.java  
```
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
```  
#### MainActivity.java  
```
package com.example.preferenceapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .add(android.R.id.content, new PrFragment())
                .commit();
    }
}
```  
#### 结果截图：  
<img src="https://github.com/2017023633/image/blob/master/image/%E5%AE%9E%E9%AA%8C4%E6%88%AA%E5%9B%BE1.png" width="250" />
