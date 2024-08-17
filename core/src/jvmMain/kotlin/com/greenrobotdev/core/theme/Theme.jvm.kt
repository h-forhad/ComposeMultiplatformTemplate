package com.greenrobotdev.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.greenrobotdev.core.ui.DarkColors
import com.greenrobotdev.core.ui.LightColors
import com.greenrobotdev.core.ui.typography

@Composable
actual fun AppTheme(
    content: @Composable () -> Unit,
) {

    val colorScheme: ColorScheme =if (isSystemInDarkTheme()) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = typography,
    )
}
