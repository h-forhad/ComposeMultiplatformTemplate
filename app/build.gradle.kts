import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    jvmToolchain(17)

//    jvm()
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm("desktop")

    sourceSets.commonMain.dependencies {
        api(project(":decompose-router"))
        implementation(compose.ui)
        implementation(compose.foundation)
        implementation(compose.material3)
        implementation(compose.runtime)
        implementation(compose.materialIconsExtended)


        implementation(libs.kotlin.corotines)
        implementation(libs.kotlin.datetime)
        implementation(libs.ktor.core)
        implementation(libs.ktor.serialization)
        implementation(libs.ktor.logging)

        implementation(libs.koin.core)
        implementation(libs.molecule.runtime)
        implementation(libs.kstore)

        implementation(libs.qdsfdhvh.image.loader)
        implementation(libs.google.services.map)
        implementation(libs.decompose.compose)
        implementation(libs.calendar.compose.basis)
        implementation(libs.calendar.compose.ranges) // includes basis
        implementation(libs.calendar.compose.pager) // includes basis
        implementation(libs.calendar.compose.datepicker) // includes pager + ranges
    }

    sourceSets.androidMain.dependencies {
        implementation(libs.androidx.activity.compose)
        implementation(libs.ktor.client)
        implementation(libs.ktor.client.okhttp)
        implementation(libs.kstore.file)
        implementation(libs.androidx.appcompat)
    }

    sourceSets.jvmMain.dependencies {
        implementation(compose.desktop.currentOs)
        implementation("androidx.collection:collection:1.4.3")

    }

    sourceSets.iosMain.dependencies {
        implementation(libs.kstore.file)
        implementation(libs.ktor.client.ios)
    }
}

/* Android Configuration */
android {
    compileSdk = 34
    namespace = "com.greenrobotdev.wanderwise.android"

    defaultConfig {
        minSdk = 29
    }
}

/* iOS Configuration */
kotlin.targets.withType<KotlinNativeTarget>().configureEach {
    binaries.framework {
        baseName = "WanderWise"
        isStatic = true

        export(project(":decompose-router"))
    }
}
