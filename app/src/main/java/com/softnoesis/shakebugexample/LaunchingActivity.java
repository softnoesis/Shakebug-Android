package com.softnoesis.shakebugexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.softnoesis.shakebuglibrary.ShakeBug;
import com.softnoesis.shakebuglibrary.shakeBugCustomUtils.ShakebugCustomize;
import com.softnoesis.shakebuglibrary.shakeBugUtils.ShakeBugAppPreference;

public class LaunchingActivity extends AppCompatActivity {

    private SwitchCompat switchOpenShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Replace with your key from shakebug dashboard in identifier key section
        ShakeBug.sharedInstance().initiateWithKey(this, "2LhP2d6MP31QMRTjS1aYmQUmEiy35K");
        ShakeBug.sharedInstance().showSplashScreen(true);
        ShakeBug.sharedInstance().allowToReportBugByShakingMobile(true);

        // 1. Trigger Bug Report (manual report without shaking)
        findViewById(R.id.btnTriggerBugReport).setOnClickListener(v -> {
            ShakeBug.sharedInstance().triggerBugReporting();
        });

        // 2. Show NPS Survey
        findViewById(R.id.btnShowNps).setOnClickListener(v -> {
            ShakeBug.sharedInstance().showNPSSurvey(true);
        });

        // 3. Open Shake Switch
        switchOpenShake = findViewById(R.id.switchOpenShake);
        updateShakeSwitchState();
        switchOpenShake.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ShakeBug.sharedInstance().allowToReportBugByShakingMobile(isChecked);
            Toast.makeText(this, isChecked ? "Shake detection ON" : "Shake detection OFF", Toast.LENGTH_SHORT).show();
        });

        // 4. Hit Event
        findViewById(R.id.btnHitEvent).setOnClickListener(v -> {
            ShakeBug.sharedInstance().addEventKey("test_event", "event_value_" + System.currentTimeMillis());
            Toast.makeText(this, "Event sent: test_event", Toast.LENGTH_SHORT).show();
        });

        // 5. Add Custom User
        findViewById(R.id.btnAddCustomUser).setOnClickListener(v -> {
            ShakeBug.sharedInstance().addCustomUser("usr_12345", "John Doe", "john.doe@example.com", "US", "VIP User");
            Toast.makeText(this, "Custom User Added: John Doe", Toast.LENGTH_SHORT).show();
        });

        // 6. Crash
        findViewById(R.id.btnCrash).setOnClickListener(v -> {
            throw new RuntimeException("Test Crash from ShakeBug Example App");
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateShakeSwitchState();
    }

    private void updateShakeSwitchState() {
        if (switchOpenShake != null) {
            boolean isEnabled = !new ShakeBugAppPreference(this).isShakeDisabled()
                    && Boolean.TRUE.equals(ShakebugCustomize.getInstance().getBugByShakeMobile());
            switchOpenShake.setOnCheckedChangeListener(null);
            switchOpenShake.setChecked(isEnabled);
            switchOpenShake.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ShakeBug.sharedInstance().allowToReportBugByShakingMobile(isChecked);
                Toast.makeText(this, isChecked ? "Shake detection ON" : "Shake detection OFF", Toast.LENGTH_SHORT).show();
            });
        }
    }
}