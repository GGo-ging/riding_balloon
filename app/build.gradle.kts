import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

val localPropertiesFile = rootProject.file("local.properties")
val properties = Properties()
properties.load(FileInputStream(localPropertiesFile))

android {
    namespace = "com.example.riding_balloon"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.riding_balloon"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "YOUTUBE_API_KEY", "\"${properties["youtube.api.key"]}\"")
        buildConfigField("String", "OPENAI_API_KEY", "\"${properties["openai.api.key"]}\"")

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
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Jetpack Navigation
    implementation(libs.bundles.navigation)

    // Glide
    implementation (libs.glide)

    // Network
    implementation(libs.bundles.retrofit)
    implementation(platform(libs.okhttp.bom))

    // Paging 3
    implementation(libs.androidx.paging)
    implementation(libs.room.paging)

    // Dagger Hilt
    implementation (libs.hilt)
    kapt (libs.hilt.compiler)

    // Dot indicator
    implementation(libs.dotindicator)

    // ExoPlayer, YoutubePlayer
    implementation(libs.bundles.videoplayers)

    // ViewModel
    implementation (libs.viewmodel)

    // Room
    implementation(libs.room)
    annotationProcessor(libs.room.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}

kapt {
    correctErrorTypes = true
}