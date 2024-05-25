import org.jetbrains.kotlin.psi.annotationEntryRecursiveVisitor

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("kotlin-kapt")
    id("kotlin-android")
}

android {
    namespace = "com.example.nikita_shupliakou_testandroid_vacc_2024"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nikita_shupliakou_testandroid_vacc_2024"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        buildConfigField ("String", "MOVIE_DB_BASE_IMAGES_URL", "https://fakestoreapi.com/img/")
//        buildConfigField ("String", "MOVIE_DB_API_BASE_URL", "https://fakestoreapi.com/")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation("androidx.fragment:fragment-ktx:1.7.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.8.0")
    implementation("androidx.lifecycle:lifecycle-process:2.8.0")

    // Dagger
    implementation("com.google.dagger:dagger:2.48")
    kapt("com.google.dagger:dagger-compiler:2.48")
    implementation("com.google.dagger:dagger-android:2.48")
    implementation("com.google.dagger:dagger-android-support:2.48")
    kapt("com.google.dagger:dagger-android-processor:2.48")

    // for adding recyclerview
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    // for adding cardview
    implementation("androidx.cardview:cardview:1.0.0")
    //for image
    implementation("com.github.bumptech.glide:glide:4.13.2")
    // for retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
}