package by.eapp.gosport.presentation.Profile

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import by.eapp.gosport.navigation.BottomBar

@Composable
fun ProfileScreen(
    navHostController: NavHostController
) {
    Scaffold(
        bottomBar = { BottomBar(navHostController) }
    ) {it
        Text(text = "Profile Screen")
    }
}