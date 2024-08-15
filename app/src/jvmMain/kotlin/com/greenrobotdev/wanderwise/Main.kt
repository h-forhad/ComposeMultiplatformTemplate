package com.greenrobotdev.wanderwise

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.greenrobotdev.wanderwise.screen.home.HomeScreen
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.defaultRouterContext

fun main() {
    application {
        val windowState: WindowState = rememberWindowState()
        val rootRouterContext: RouterContext = defaultRouterContext(windowState = windowState)

        Window(title = "KMP Demo", onCloseRequest = ::exitApplication) {
            CompositionLocalProvider(LocalRouterContext provides rootRouterContext) {
                HomeScreen()
            }
        }
    }
}