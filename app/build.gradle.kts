plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {

    namespace = "in.vikasrathod.androidbasic"
    compileSdk = 34

    defaultConfig {
        applicationId = "in.vikasrathod.androidbasic"
        minSdk = 14
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.core:core-ktx:1.12.0")
    testImplementation("junit:junit:4.12")

    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.recyclerview:recyclerview:1.0.0")
    implementation("com.google.android.material:material:1.0.0")
}
