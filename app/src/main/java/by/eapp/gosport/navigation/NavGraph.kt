package by.eapp.gosport.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.eapp.gosport.presentation.Menu.MenuScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Menu.route,
        modifier = modifier) {
        composable(Screens.Menu.route) {
            MenuScreen(navController = navController)
        }
       composable(Screens.Profile.route) {

       }
        composable(Screens.ShoppingCart.route) {

        }
    }
}
