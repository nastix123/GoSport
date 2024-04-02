package by.eapp.gosport.navigation

import by.eapp.gosport.R



sealed class Screens(
    val route: String,
    val icon: Int,
    val title: String
) {
    data object Menu : Screens(
        "menu",
         R.drawable.ic_launcher_foreground,
        "Меню"
    )

    data object Profile : Screens(
        "profile",
        R.drawable.ic_launcher_foreground,
        "Профиль"
    )

    data object ShoppingCart : Screens(
        "cart",
        R.drawable.ic_launcher_foreground,
        "Корзина"
    )

}
