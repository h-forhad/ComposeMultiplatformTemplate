package com.greenrobotdev.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.greenrobotdev.core.ui.DarkColors
import com.greenrobotdev.core.ui.LightColors
import com.greenrobotdev.core.ui.typography

@Composable
actual fun AppTheme(
    content: @Composable () -> Unit
) {

    val useDarkTheme = true
    val colors = when {
        useDarkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content,
        typography = typography
    )
}
