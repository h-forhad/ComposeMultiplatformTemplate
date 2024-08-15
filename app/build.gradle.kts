import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    jvmToolchain(17)

    jvm()
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets.commonMain.dependencies {
        api(project(":decompose-router"))
        implementation(compose.foundation)
        implementation(compose.material3)
        implementation(compose.runtime)
    }

    sourceSets.androidMain.dependencies {
        implementation("androidx.activity:activity-compose:1.9.0")
        implementation("androidx.appcompat:appcompat:1.7.0")
    }

    sourceSets.jvmMain.dependencies {
        implementation(compose.desktop.currentOs)
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
