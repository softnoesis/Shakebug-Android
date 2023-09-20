package com.softnoesis.shakebugexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.softnoesis.shakebuglibrary.ShakeBug;
import com.softnoesis.shakebuglibrary.shakenugCustomUtils.ShakebugLanguage;


public class LaunchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Replace with your key from shakebug dashboard in indentifier key section
        ShakeBug.sharedInstance().initiateWithKey(this,"Shakebug Key");
    }
}