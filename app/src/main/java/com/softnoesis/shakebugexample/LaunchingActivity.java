package com.softnoesis.shakebugexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.softnoesis.shakebuglibrary.ShakeBugInitialize;

public class LaunchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShakeBug.sharedInstance().initiateWithKey(this, "Your_Key");
        ShakeBug.sharedInstance().showSplashScreen(true);    
    }
}
