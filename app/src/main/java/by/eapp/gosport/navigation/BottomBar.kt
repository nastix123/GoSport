package by.eapp.gosport.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import by.eapp.gosport.ui.theme.NavBar
import by.eapp.gosport.ui.theme.SelectedItem

@Composable
fun BottomBar(
    navController: NavHostController,
) {

    val items = listOf(
        Screens.Menu,
        Screens.Profile,
        Screens.ShoppingCart
    )

    val showBottomBar =
        navController.currentBackStackEntryAsState().value?.destination?.route in items.map { it.route }

    if (showBottomBar) {
        BottomNavigation(
            backgroundColor = NavBar
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = {
                        val iconTint = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                            SelectedItem
                        } else {
                            Color.DarkGray
                        }
                        Icon(
                            imageVector = ImageVector.vectorResource(screen.icon),
                            contentDescription = screen.route,
                            tint = iconTint
                        )
                    },
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
