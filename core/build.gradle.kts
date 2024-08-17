plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {

    jvm()

    androidTarget()

    jvmToolchain(17)

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    sourceSets.commonMain.dependencies {
        implementation(compose.ui)
        implementation(compose.foundation)
        implementation(compose.material3)
        implementation(compose.material)
        implementation(compose.runtime)
        implementation(compose.materialIconsExtended)
        implementation(libs.kotlin.corotines)
        implementation(libs.kotlin.datetime)

        implementation(libs.ktor.core)
        implementation(libs.ktor.content.negotiation)
        implementation(libs.ktor.serialization)
        implementation(libs.ktor.logging)

        implementation(libs.koin.core)
        implementation(libs.molecule.runtime)
        implementation(libs.kstore)

    }

    sourceSets.androidMain.dependencies {
        implementation(libs.ktor.client.android)
        implementation(libs.ktor.client.okhttp)
        implementation(libs.sql.delight.android)
        implementation(libs.kstore.file)
    }

    sourceSets.jvmMain.dependencies {
        implementation(compose.desktop.currentOs)
    }

    sourceSets.iosMain.dependencies {
        implementation(libs.kstore.file)
        implementation(libs.ktor.client.ios)
        implementation(libs.sql.delight.ios)
        implementation(libs.kstore.file)
        implementation(libs.ktor.client.ios)
        implementation(libs.sql.delight.ios)
    }
}


android {
    namespace = "com.greenrobotdev.planner"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


}