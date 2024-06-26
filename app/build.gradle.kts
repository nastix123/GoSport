plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin ("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "by.eapp.gosport"
    compileSdk = 34

    defaultConfig {
        applicationId = "by.eapp.gosport"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // Retrofit-okhttp
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation ("com.squareup.retrofit2:converter-gson:2.5.0")


    // Parsing
    implementation ("com.google.code.gson:gson:2.10.1")


    // Compose dependencies
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation ("androidx.navigation:navigation-compose:2.7.7")
    implementation ("androidx.compose.material:material-icons-extended")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("androidx.compose.material:material:1.6.4")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")


    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.49")
    kapt("com.google.dagger:hilt-android-compiler:2.49")
    kapt("androidx.hilt:hilt-compiler:1.2.0")
    implementation("androidx.hilt:hilt-work:1.2.0")

    // Paging with compose

    implementation ("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation ("androidx.paging:paging-compose:3.2.1")

    // Coil compose
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation ("androidx.work:work-runtime-ktx:2.9.0")

    //Room
    val room_version = "2.6.1"
    implementation ("androidx.room:room-runtime:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-paging:$room_version")

}