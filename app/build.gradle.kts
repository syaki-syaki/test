plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.sasakitest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.sasakitest"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    // OkHttpライブラリ
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    // Androidライブラリ
    implementation("androidx.core:core-ktx:1.15.0")                // 最新バージョンに更新
    implementation("androidx.appcompat:appcompat:1.7.0")   // 最新バージョンに更新
    implementation("com.google.android.material:material:1.12.0")  // 最新バージョンに更新
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")  // 最新バージョンに更新
    implementation("com.google.code.gson:gson:2.10.1")             // 最新バージョンに更新
    implementation ( "com.google.code.gson:gson:2.9.0")
    // テスト用ライブラリ
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.2.1")     // 最新バージョンに更新
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")  // 最新バージョンに更新
}