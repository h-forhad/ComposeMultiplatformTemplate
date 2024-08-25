package com.greenrobotdev.favily.desktop

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.greenrobotdev.core.coreModule
import com.greenrobotdev.onlinestore.di.appStorage
import com.greenrobotdev.onlinestore.onlineStoreModule
import com.greenrobotdev.favily.appModule
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.defaultRouterContext
import org.koin.core.context.startKoin

fun main() {
  application {
    val windowState: WindowState = rememberWindowState()
    val rootRouterContext: RouterContext = defaultRouterContext(windowState = windowState)

    startKoin {
      modules(appModule)
      modules(coreModule)
      modules(onlineStoreModule)
    }

    appStorage = System.getProperty("user.home")

    Window(
      title = "WanderWise",
      state = windowState,
      onCloseRequest = { exitApplication() }
    ) {
      CompositionLocalProvider(
        LocalRouterContext provides rootRouterContext,
      ) {
          com.greenrobotdev.onlinestore.screen.home.HomeScreen()
      }
    }
  }
}
