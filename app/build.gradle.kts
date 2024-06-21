plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.electronicwalletmoneypay"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.electronicwalletmoneypay"
        minSdk = 28
        targetSdk = 34
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
    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation ("com.github.yuriy-budiyev:code-scanner:2.3.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.akexorcist:localization:1.2.11")
    implementation ("com.github.takuji31.Koreference:koreference:2.0.0")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.15.2")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.jakewharton.timber:timber:5.0.1")
    implementation ("io.insert-koin:koin-core:3.4.2")
    implementation ("io.insert-koin:koin-android:3.4.2")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.5")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}