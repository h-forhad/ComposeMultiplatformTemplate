package com.greenrobotdev.wanderwise

import com.greenrobotdev.wanderwise.api.appApiModule
import com.greenrobotdev.wanderwise.data.appDataModule

val appModule = listOf(appApiModule, appDataModule)