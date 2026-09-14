# ShakeBug Android

[![Maven Central](https://img.shields.io/maven-central/v/com.softnoesis.shakebug/ShakeBug.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:com.softnoesis.shakebug)

ShakeBug is an AI-powered bug, crash, and product analytics platform for Android, iOS, Flutter, React Native, and web apps. Users can report an issue with a shake or screenshot event, while ShakeBug captures the context needed to investigate it, including device data, network information, and session activity. Bug and crash reports, custom events, user journeys, and product analytics are available in the ShakeBug dashboard.

Sign up at [shakebug.com](https://www.shakebug.com).

## Features

- Image and screen-recording bug reporting
- Automatic crash reporting
- Analytics and custom events
- In-app review popup
- Remote configuration
- NPS (Net Promoter Score) popup
- Custom user tracking
- Custom language, theme color, titles, and error messages
- On-premise endpoint support

## Compatibility

- Minimum Android SDK: 21
- Compile SDK: 33
- Target SDK: 33

## Installation

Add Maven Central and JitPack to the repositories available to your project:

```groovy
buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Then add ShakeBug to your app module's `build.gradle` file:

```groovy
dependencies {
    implementation 'com.softnoesis.shakebug:ShakeBug:1.2.50'
}
```

Configure compatible SDK versions in the app module:

```groovy
android {
    compileSdk 33

    defaultConfig {
        minSdk 21
        targetSdk 33
    }
}
```

## Initialize ShakeBug

Initialize ShakeBug from the launching `Activity` or your `Application` class. Replace `<Your Key>` with the application key from the ShakeBug dashboard.

```java
// Java
ShakeBug.sharedInstance().initiateWithKey(this, "<Your Key>");
```

```kotlin
// Kotlin
ShakeBug.sharedInstance().initiateWithKey(this, "<Your Key>")
```

## Optional settings

### Tutorial screen

Show or hide the first-time ShakeBug tutorial screen. The default is `true`.

```java
ShakeBug.sharedInstance().showTutorialScreenFirstTime(false);
```

```kotlin
ShakeBug.sharedInstance().showTutorialScreenFirstTime(false)
```

### Language

By default, ShakeBug uses the device language. Set a language explicitly when needed.

```java
ShakeBug.sharedInstance().setShakebugLanguage(ShakebugLanguage.SPANISH, this);
```

```kotlin
ShakeBug.sharedInstance().setShakebugLanguage(ShakebugLanguage.SPANISH, this)
```

### Theme color

```java
ShakeBug.sharedInstance().setShakebugThemeColor(134, 235, 52);
```

```kotlin
ShakeBug.sharedInstance().setShakebugThemeColor(134, 235, 52)
```

### Custom titles and error message

```java
ShakeBug.sharedInstance().changeSDKScreenTitle("Annotate your Bug", "Feedback");
ShakeBug.sharedInstance().changeSDKErrorAlertMessage("Something went wrong.");
```

```kotlin
ShakeBug.sharedInstance().changeSDKScreenTitle("Annotate your Bug", "Feedback")
ShakeBug.sharedInstance().changeSDKErrorAlertMessage("Something went wrong.")
```

### On-premise endpoint

For an on-premise hosting plan, configure the endpoint URL, header key, and optional SSL public key.

```java
ShakeBug.sharedInstance().setShakebugSDKEndPointURL("", "", "");
```

```kotlin
ShakeBug.sharedInstance().setShakebugSDKEndPointURL("", "", "")
```

### Bug-reporting triggers

Enable or disable the two built-in reporting triggers independently.

```java
ShakeBug.sharedInstance().allowToReportBugByShakingMobile(true);
ShakeBug.sharedInstance().allowToReportBugByScreenCapture(true);
```

```kotlin
ShakeBug.sharedInstance().allowToReportBugByShakingMobile(true)
ShakeBug.sharedInstance().allowToReportBugByScreenCapture(true)
```

## Events

Record a custom event to track a meaningful user action.

```java
ShakeBug.sharedInstance().addEventKey("app_open", "Started app");
```

```kotlin
ShakeBug.sharedInstance().addEventKey("app_open", "Started app")
```

## Set custom user details

Associate user information with sessions, feedback, and crash reports for more useful investigation and reporting.

```java
ShakeBug.sharedInstance().addCustomUser(
        "user_123", "John Doe", "john.doe@example.com", "USA", "Android beta tester"
);
```

```kotlin
ShakeBug.sharedInstance().addCustomUser(
    "user_123", "John Doe", "john.doe@example.com", "USA", "Android beta tester"
)
```

## Remote configuration

Fetch a dashboard-defined configuration value without releasing a new app version.

```java
ShakeBug.sharedInstance().getRemoteValue("your_key", new ShakeBug.RemoteConfigCallback() {
    @Override
    public void onResult(String configKey, String value) {
        // Use value
    }

    @Override
    public void onError(String error) {
        // Handle error
    }
});
```

```kotlin
ShakeBug.sharedInstance().getRemoteValue("your_key", object : ShakeBug.RemoteConfigCallback {
    override fun onResult(configKey: String, value: String) {
        // Use value
    }

    override fun onError(error: String) {
        // Handle error
    }
})
```

## Review popup

When reviews are enabled for the app in the ShakeBug dashboard, the Android SDK manages the review popup automatically after the SDK validates the app. It waits until the app has been opened at least three times and at least two days have passed since the last review prompt. After a user submits a review, the SDK does not show it again while that app data is retained.

No separate Android API call is required or exposed to manually trigger the review popup. To disable it, turn off the review-popup option for the app in the ShakeBug dashboard.

## NPS popup

The NPS popup collects a score from 0 to 10 and an optional comment. It is intended for measuring user satisfaction and collecting qualitative feedback.

### Eligibility-controlled NPS flow

Call the default method at an appropriate product moment, such as after a user completes an important workflow. The SDK silently skips the popup unless all of these rules pass:

- At least three app sessions since first initialization
- At least three days since first installation
- At least 90 days since the user last submitted an NPS survey
- At least 14 days since the user last selected **Not now**
- Fewer than four asks in the preceding 365 days
- The app is in the foreground and another ShakeBug overlay is not open
- The survey has not already been shown during the current session

```java
ShakeBug.sharedInstance().showNPSSurvey();
```

```kotlin
ShakeBug.sharedInstance().showNPSSurvey()
```

Use `isNPSEligible()` when you need to decide whether to present your own entry point before calling the default method.

```java
if (ShakeBug.sharedInstance().isNPSEligible()) {
    ShakeBug.sharedInstance().showNPSSurvey();
}
```

### Force-show NPS survey

For an explicit user-requested action, such as a **Rate us** button, pass `true`. This bypasses all eligibility and timing rules and opens the survey immediately.

```java
rateUsButton.setOnClickListener(view ->
        ShakeBug.sharedInstance().showNPSSurvey(true)
);
```

```kotlin
rateUsButton.setOnClickListener {
    ShakeBug.sharedInstance().showNPSSurvey(true)
}
```

### NPS use cases

1. **Measure user satisfaction.** Collect a 0–10 score that reflects how users feel about the app.
2. **Identify promoters and detractors.** Find highly satisfied users and users who may be experiencing friction.
3. **Collect actionable feedback.** Let users explain their score in the optional comment field.
4. **Measure product experience over time.** The 90-day post-submission interval supports periodic feedback without over-prompting.
5. **Follow a major feature release.** Offer a force-show survey from a deliberate, user-visible feedback action.
6. **Evaluate important workflows.** Call the eligibility-controlled method after a meaningful user activity to understand that experience.

## Usage

Build and run the app. Shake the device to begin a bug report, or enable the screen-capture trigger if that suits your workflow. Reports are sent to the ShakeBug dashboard and notification email configured for the account.

## Contact

Visit [shakebug.com](https://www.shakebug.com) or contact [support@shakebug.com](mailto:support@shakebug.com).
