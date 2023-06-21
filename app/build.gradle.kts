@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
    id(libs.plugins.kotlin.parcelize.get().pluginId)
}

android {
    defaultConfig {
        applicationId = "ru.myitschool.lab23"
        versionCode = 1
        versionName = "0.0.1"

        targetSdk = 33
        minSdk = 27
        compileSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        warningsAsErrors = true
        ignoreWarnings = false
        abortOnError = true
        checkAllWarnings = true
        lintConfig = file("lint.xml")
        lint {
            disable.addAll(
                listOf(
                    "InvalidPackage",
                    "UnusedIds",
                    "GradleDependency",
                    "UnusedResources",
                    "UnknownNullness",
                    "SyntheticAccessor",
                ),
            )
        }
    }

    applicationVariants.all {
        val lintTask = tasks["lint${name.capitalize()}"]
        assembleProvider.get().dependsOn.add(lintTask)
    }

    buildFeatures {
        viewBinding = true
    }
    namespace = "ru.myitschool.lab23"
}

dependencies {

    implementation(libs.android.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.androidx.constraintlayout)

    implementation("com.google.mlkit:barcode-scanning:17.0.3")
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)
    implementation(libs.kotlinx.coroutines.android)

    androidTestImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation(libs.kakao)
    androidTestImplementation(libs.androidx.test.uiautomator)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.espresso.accessibility)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(kotlin("test"))
    testImplementation(libs.androidx.test.ext)
}
