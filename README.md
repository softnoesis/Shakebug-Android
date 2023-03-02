# Shakebug-Android
[![Maven Central](https://img.shields.io/maven-central/v/com.softnoesis.shakebug/ShakeBug.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:com.softnoesis.shakebug)

Shakebug allows you to receive feedback from your beta testers or real users and improve the quality of your application in a simple way. Here users just need to shake their mobile and all the data regarding bugs & crashes can be seen by developers through their log in panel. It also helpful to analyse your users, session, location etc. Addition, you can add events on each action of your application and track it using this Shakebug framework.

Sign up for a service at https://www.shakebug.com

## Installation

### Gradle

Add this line to your build.gradle file.

```groovy
implementation 'com.softnoesis.shakebug:ShakeBug:1.2.18'
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

## Usage

Build & run your app. Once your app is running, shake your device to report a bug! Bug/Crash reports are sent directly to login panel of Shakebug.com and also notify on your registered email address.


## Contact
Visit on: [https://www.shakebug.com](https://www.shakebug.com)

Contact us on support@shakebug.com in case of any use.
