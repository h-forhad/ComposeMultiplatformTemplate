package com.greenrobotdev.wanderwise

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.greenrobotdev.wanderwise.screen.home.HomeScreen
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.defaultRouterContext

//class MainActivity: AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        val rootComponentContext: RouterContext = defaultRouterContext()
//
//
//        setContent {
//            CompositionLocalProvider(LocalRouterContext provides rootComponentContext) {
//
//                Surface(tonalElevation = 5.dp) {
//                    HomeScreen()
//                }
//
//            }
//        }
//    }
//}