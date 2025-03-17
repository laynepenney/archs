/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pro.layne.sample.archs.feature.pattern.ui.PatternScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { PatternScreen(modifier = Modifier.padding(16.dp)) }
        // TODO: Add more destinations
    }
}
