package com.greenrobotdev.core.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.ui.unit.dp

actual val WindowInsets.Companion.navigationBarPadding: WindowInsets
    get() = WindowInsets(100.dp)
actual val WindowInsets.Companion.statusBarPadding: WindowInsets
    get() = WindowInsets(40.dp)