package by.eapp.gosport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import by.eapp.gosport.navigation.NavGraph
import by.eapp.gosport.ui.theme.GoSportTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                val navController = rememberNavController()
                NavGraph(navController = navController)


        }
    }
}

