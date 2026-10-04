package com.willian.ourofino.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.willian.ourofino.R
import com.willian.ourofino.ui.screens.AboutScreen
import com.willian.ourofino.ui.screens.AttractionsScreen
import com.willian.ourofino.ui.screens.HistoryScreen
import com.willian.ourofino.ui.screens.HomeScreen

sealed class Screen(val route: String, val label: Int, val icon: Int) {
    object Home : Screen("home", R.string.nav_home, R.drawable.ic_home)
    object History : Screen("history", R.string.nav_history, R.drawable.ic_history)
    object Attractions : Screen("attractions", R.string.nav_attractions, R.drawable.ic_location)
    object Map : Screen("map", R.string.nav_map, R.drawable.ic_map)
    object About : Screen("about", R.string.nav_about, R.drawable.ic_info)
}

val items = listOf(
    Screen.Home,
    Screen.History,
    Screen.Attractions,
    Screen.Map,
    Screen.About
)

@Composable
fun OuroFinoApp() {
    val navController = rememberNavController()
    val darkTheme = isSystemInDarkTheme()

    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination

                        items.forEach { screen ->
                            NavigationBarItem(
                                icon = { Icon(painterResource(id = screen.icon), contentDescription = null) },
                                label = { Text(stringResource(screen.label)) },
                                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        lazyRestoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                NavHost(
                    navController,
                    startDestination = Screen.Home.route,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(Screen.Home.route) { HomeScreen(navController) }
                    composable(Screen.History.route) { HistoryScreen() }
                    composable(Screen.Attractions.route) { AttractionsScreen(navController) }
                    composable(Screen.Map.route) { MapScreen() }
                    composable(Screen.About.route) { AboutScreen() }
                }
            }
        }
    }
}

@Composable
fun lightColorScheme() = lightColorScheme(
    primary = androidx.compose.material3.Color(0xFFFFD700),
    secondary = androidx.compose.material3.Color(0xFFB8860B),
    tertiary = androidx.compose.material3.Color(0xFF2E7D32)
)

@Composable
fun darkColorScheme() = darkColorScheme(
    primary = androidx.compose.material3.Color(0xFFFFD700),
    secondary = androidx.compose.material3.Color(0xFFB8860B),
    tertiary = androidx.compose.material3.Color(0xFF4CAF50)
)

@Composable
fun MapScreen() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text("Mapa em desenvolvimento")
    }
}
