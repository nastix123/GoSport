package by.eapp.gosport.presentation.Cart

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import by.eapp.gosport.navigation.BottomBar

@Composable
fun ShoppingCartScreen(
    navHostController: NavHostController
) {
    Scaffold(
        bottomBar = { BottomBar(navHostController) }
    ) {it
        Text(text = "Cart Screen")
    }
}