package com.greenrobotdev.wanderwise

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.greenrobotdev.wanderwise.screen.home.HomeScreen
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext

@Suppress("unused") // used by swift code
fun createViewController(
    routerContext: RouterContext
) = ComposeUIViewController {
    BoxWithConstraints(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {

        CompositionLocalProvider(
            LocalRouterContext provides routerContext,
        ) {
            Surface(tonalElevation = 5.dp) {
                HomeScreen()
            }
        }
    }
}