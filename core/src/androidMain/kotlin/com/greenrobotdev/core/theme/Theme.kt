package com.greenrobotdev.core.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.greenrobotdev.core.ui.DarkColors
import com.greenrobotdev.core.ui.LightColors
import com.greenrobotdev.core.ui.shapes
import com.greenrobotdev.core.ui.typography

@Composable
actual fun AppTheme(
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val useDarkTheme = isSystemInDarkTheme()
    val colors = when {
        (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) -> {
            if (useDarkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        useDarkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content,
        shapes = shapes,
        typography = typography
    )
}
