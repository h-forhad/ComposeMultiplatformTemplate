package com.greenrobotdev.wanderwise.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.greenrobotdev.core.theme.AppTheme
import com.greenrobotdev.onlinestore.di.appStorage
import com.greenrobotdev.wanderwise.screen.home.HomeScreen
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.defaultRouterContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appStorage = filesDir.path

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val rootComponentContext: RouterContext = defaultRouterContext()

        setContent {
            CompositionLocalProvider(LocalRouterContext provides rootComponentContext) {
                AppTheme {
                    Surface(tonalElevation = 5.dp) {
                        com.greenrobotdev.onlinestore.screen.home.HomeScreen()
                    }
                }

            }
        }
    }
}
