package com.greenrobotdev.core.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.ui.unit.dp

// TODO: Figure out what the actual insets are here
actual val WindowInsets.Companion.statusBarPadding: WindowInsets get() = WindowInsets(top = 0.dp)

actual val WindowInsets.Companion.navigationBarPadding: WindowInsets get() = WindowInsets(bottom = 8.dp)
