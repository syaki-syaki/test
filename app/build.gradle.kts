plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "1.9.0"
    id("kotlin-parcelize")
    id("com.apollographql.apollo3") version "4.1.0" // ✅ v4系に更新！
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
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
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
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")

    // Corrected duplicate dependency
    // implementation("com.apollographql.apollo3:apollo-normalized-cache:3.8.2")
    implementation("com.apollographql.apollo3:apollo-normalized-cache:4.1.0")
    implementation("com.apollographql.apollo3:apollo-runtime:4.1.0")
    implementation("com.apollographql.apollo3:apollo-api:4.1.0")

    // Gson（もし必要なら）
    implementation("com.google.code.gson:gson:2.10.1")

    // テスト用
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}

apollo {
    service("github") {
        packageName.set("com.example.sasakitest.graphql")
        schemaFile.set(file("src/main/graphql/schema.graphqls")) // ✅ graphqls形式に変更済
        srcDir("src/main/graphql") // ✅ クエリファイルの場所を明示（任意だが推奨）
        customScalarsMapping.set(
            mapOf("URI" to "kotlin.String") // ✅ スカラー型変換
        )
    }
}