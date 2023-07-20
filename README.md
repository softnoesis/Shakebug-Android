# Shakebug-Android
[![Maven Central](https://img.shields.io/maven-central/v/com.softnoesis.shakebug/ShakeBug.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:com.softnoesis.shakebug)

Shakebug allows you to receive feedback from your beta testers or real users and improve the quality of your application in a simple way. Here users just need to shake their mobile and all the data regarding bugs & crashes can be seen by developers through their log in panel. It also helpful to analyse your users, session, location etc. Addition, you can add events on each action of your application and track it using this Shakebug framework.

Sign up for a service at https://www.shakebug.com

## Installation

### Gradle

Add this line to your build.gradle file.

```groovy
implementation 'com.softnoesis.shakebug:ShakeBug:1.2.25'
```

## Usage

In your `Application class` or `Launching activity` add this line to your `onCreate` method.

**Java**
```java
 ShakeBug.sharedInstance().initiateWithKey(this, "<Your Key>");
```
**Kotlin**
```kotlin
 ShakeBug.sharedInstance().initiateWithKey(this,"<Your Key>")
```
    
Be sure to replace `<Your Key>` with your application key which given by ShakeBug website.

Then, update the following sdkVersion to your app's `build.gradle` file:
```gradle
android {
    compileSdk 33
        defaultConfig {
             ...
             targetSdk 33
             ...
        }
        ...
}```
```

You may also need to add the following to your project/build.gradle file:

```gradle
buildscript {
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

For a seamless experience with our SDK, include maven { url 'https://jitpack.io' } in your build.gradle file under allprojects > repositories . Avoid potential issues and enjoy smooth integration.

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

## Optional Settings

1. If you want add event to any screen or activity use following methods

**Java**
```java
ShakeBug.sharedInstance().addEventKey(this,"<Key>","<Key Value>"); //pass any key or value
```

**Kotlin**
```kotlin
ShakeBug.sharedInstance().addEventKey(this,"<Key>","<Key Value>") // pass any key or value
```
   
2. Add the following for enabling/disabling first time tutorial screen

**Java**
```java
ShakeBug.sharedInstance().showTutorialScreenFirstTime(true); // Default value True
```

**Kotlin**
```kotlin
ShakeBug.sharedInstance().showTutorialScreenFirstTime(true) // Default value True
```

3. Add the following to set custom language for shakebug

**Java**
```java
ShakeBug.sharedInstance().setShakebugLanguage(ShakebugLanguage.SPANISH,this);
```

**Kotlin**
```kotlin
ShakeBug.sharedInstance().setShakebugLanguage(ShakebugLanguage.SPANISH,this)
```

4. Add the following to set custom Theme color for shakebug

**Java**
```java
ShakeBug.sharedInstance().setShakebugThemeColor(134,235,52);
```

**Kotlin**
```kotlin
ShakeBug.sharedInstance().setShakebugThemeColor(134,235,52)
```

5. Add the following to set custom Screen title for shakebug

**Java**
```java
ShakeBug.sharedInstance().changeSDKScreenTitle("Annotate your Bug", "Feedback");
```

**Kotlin**
```kotlin
ShakeBug.sharedInstance().changeSDKScreenTitle("Annotate your Bug", "Feedback")
```

6. Add the following to set custom error message for shakebug

**Java**
```java
ShakeBug.sharedInstance().changeSDKErrorAlertMessage("Something wrong...");
```

**Kotlin**
```kotlin
ShakeBug.sharedInstance().changeSDKErrorAlertMessage("Something wrong...")
```

7. Add the following to set custom endpoint for shakebug

**Java**
```java
ShakeBug.sharedInstance().setShakebugSDKEndPointURL("","","");
```

**Kotlin**
```kotlin
ShakeBug.sharedInstance().setShakebugSDKEndPointURL("","","")
```

3. Add the following to set trigger shakebug

**Java**
```java
ShakeBug.sharedInstance().triggerBugReporting();
```

**Kotlin**
```kotlin
ShakeBug.sharedInstance().triggerBugReporting()
```

## Usage

Build & run your app. Once your app is running, shake your device to report a bug! Bug/Crash reports are sent directly to login panel of Shakebug.com and also notify on your registered email address.


## Contact
Visit on: [https://www.shakebug.com](https://www.shakebug.com)

Contact us on support@shakebug.com in case of any use.
