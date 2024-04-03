package by.eapp.gosport.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.eapp.gosport.presentation.Cart.ShoppingCartScreen
import by.eapp.gosport.presentation.Menu.MenuScreen
import by.eapp.gosport.presentation.Menu.MenuViewModel
import by.eapp.gosport.presentation.Profile.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModelMenu = hiltViewModel<MenuViewModel>()
    NavHost(
        navController = navController,
        startDestination = Screens.Menu.route,
        modifier = modifier) {
        composable(Screens.Menu.route) {
            MenuScreen(
                navController = navController,
                viewModel = viewModelMenu
            )
        }
       composable(Screens.Profile.route) {
            ProfileScreen(navHostController = navController)
       }
        composable(Screens.ShoppingCart.route) {
            ShoppingCartScreen(navHostController = navController)
        }
    }
}
