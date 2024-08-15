plugins {
//    kotlin("multiplatform") version "2.0.0" apply false
//    kotlin("plugin.compose") version "2.0.0" apply false
//    id("com.android.application") version "8.5.1" apply false
//    id("org.jetbrains.compose") version "1.6.11" apply false
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.jetbrainsCompose).apply(false)
}