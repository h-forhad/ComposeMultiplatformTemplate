package com.greenrobotdev.core.utils

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

val  LocalWindowSizeClass : ProvidableCompositionLocal<WindowSizeClass> = staticCompositionLocalOf { error("nothing provided for window size") }