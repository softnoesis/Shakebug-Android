# Shakebug-Android
[![Maven Central](https://img.shields.io/maven-central/v/com.softnoesis.shakebug/ShakeBug.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:com.softnoesis.shakebug)

Shakebug allows you to receive feedback from your beta testers or real users and improve the quality of your application in a simple way. Here users just need to shake their mobile and all the data regarding bugs & crashes can be seen by developers through their log in panel. It also helpful to analyse your users, session, location etc. Addition, you can add events on each action of your application and track it using this Shakebug framework.

Sign up for a service at https://www.shakebug.com

## Installation

### Gradle

Add this line to your build.gradle file.

```groovy
implementation 'com.softnoesis.shakebug:ShakeBug:<latest-version>'
```

## Usage

In your `Application class` or `Launching activity` add this line to your `onCreate` method.

**Java**
```java
new ShakeBugInitialize(this,"APP_TOKEN");
```
**Kotlin**
```kotlin
ShakeBugInitialize(this,"APP_TOKEN")
```
