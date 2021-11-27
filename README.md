# Shakebug-Android
[![Maven Central](https://img.shields.io/maven-central/v/com.softnoesis.shakebug/ShakeBug.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:com.softnoesis.shakebug)

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
