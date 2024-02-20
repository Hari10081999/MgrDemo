plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.aim.demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aim.demo"
        minSdk = 24
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
        dataBinding = true
        viewBinding = true
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
    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.lifecycle:lifecycle-livedata-core-ktx:2.6.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation ("androidx.annotation:annotation:1.6.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("com.android.volley:volley:1.2.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("com.android.support:multidex:1.0.3")

    //jackson parser
    api ("com.squareup.retrofit2:converter-jackson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    api ("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    api ("com.fasterxml.jackson.core:jackson-core:2.13.3")
    api ("com.fasterxml.jackson.core:jackson-annotations:2.13.3")
    // Retrofit
    api ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    api ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    api ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.10")
    api ("com.squareup.okhttp3:okhttp-urlconnection:5.0.0-alpha.10")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    // Reactive X android
    api ("io.reactivex.rxjava2:rxandroid:2.1.1")
    // Because RxAndroid releases are few and far between, it is recommended you also explicitly depend on RxJava's latest version for bug fixes and new features.
    api ("io.reactivex.rxjava2:rxjava:2.2.21")

    // For Image zooming
    api ("com.ablanco.zoomy:zoomy:1.1.0")

    //play update
    implementation ("com.google.android.play:core:1.10.3")
    implementation ("com.google.android.play:core-ktx:1.8.1")

    //play service auth
    implementation ("com.google.android.gms:play-services-auth:20.5.0")
    implementation ("com.google.android.gms:play-services-maps:18.1.0")
    implementation ("com.google.android.gms:play-services-location:21.0.1")

    // Import the BoM for the Firebase platform
    implementation ("com.google.firebase:firebase-bom:30.3.1")
    // Declare the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation ("com.google.firebase:firebase-auth:22.0.0")
    //FCM notification
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation ("com.google.firebase:firebase-messaging:23.1.2")
    implementation ("com.google.firebase:firebase-crashlytics:18.3.7")
    implementation ("com.google.firebase:firebase-analytics:21.3.0")
    implementation ("com.google.firebase:firebase-firestore:24.6.1")


    implementation ("com.makeramen:roundedimageview:2.3.0")
    implementation ("com.airbnb.android:lottie:5.2.0")
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    implementation ("androidx.biometric:biometric:1.1.0")
    implementation ("com.github.otpless-tech:otpless-android-sdk:1.1.4")

    implementation ("com.facebook.android:facebook-android-sdk:5.15.3")

    implementation ("bouncycastle:bcprov-jdk16:136")

    implementation ("com.google.code.gson:gson:2.9.0")
    implementation ("org.jetbrains.anko:anko:0.10.8")

    //Socket.io
    implementation("io.socket:socket.io-client:2.0.0") {
      //  exclude group: 'org.json', module: 'json'
    }
    implementation ("com.github.2coffees1team:GlideToVectorYou:v2.0.0")


    implementation ("com.google.android.exoplayer:exoplayer:2.11.1")
    implementation ("com.google.android.exoplayer:exoplayer-core:2.11.1")
}