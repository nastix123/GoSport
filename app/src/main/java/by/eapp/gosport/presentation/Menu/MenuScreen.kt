package by.eapp.gosport.presentation.Menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import by.eapp.gosport.navigation.BottomBar
import by.eapp.gosport.presentation.Menu.Components.BannerRow
import by.eapp.gosport.presentation.Menu.Components.DropdownList
import by.eapp.gosport.presentation.Menu.Components.FilterRow
import by.eapp.gosport.presentation.Menu.Components.MenuColumn

@Composable
fun MenuScreen(
    navController: NavHostController,
    viewModel: MenuViewModel = hiltViewModel(),
) {

    val categories = viewModel.categories.collectAsState()
    val selectedCity = remember { mutableStateOf("") }
    val menuItems = viewModel.dishes.collectAsLazyPagingItems()
    val cities = listOf(
        "Москва",
        "Санкт-Петербург",
        "Астрахань",
        "Казань",
        "Новосибирск",
        "Волгоград",
        "Владивосток"
    )

    val showDropdown = remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        it
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = selectedCity.value)

                    DropdownList(
                        itemList = cities,
                        selectedIndex = 0,
                        onItemClick = { index -> selectedCity.value = cities[index] },
                        modifier = Modifier.padding(bottom = 16.dp),
                        icon = Icons.Default.ArrowDropDown,
                        showDropdown = showDropdown.value
                    )
                }
                Icon(
                    imageVector = Icons.Default.QrCode,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            BannerRow()
            Spacer(modifier = Modifier.height(10.dp))
            FilterRow(
                filters = categories.value,
                viewModel = viewModel
            )
            Spacer(modifier = Modifier.height(10.dp))
            MenuColumn(listOfDishes = menuItems)
        }
    }
}


@Preview
@Composable
fun previewMenuScreen() {
    MenuScreen(
        navController = NavHostController(context = LocalContext.current),
        viewModel = hiltViewModel<MenuViewModel>()
    )
}

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String = "",
    textAlign: TextAlign = TextAlign.Center,
    fontSize: Int = 16,
    color: Color = Color.Black,
    fontFamily: FontFamily = FontFamily.Default,
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.Normal,
    textDecoration: TextDecoration = TextDecoration.None,
) {
    Text(
        text = text,
        textAlign = textAlign,
        fontSize = fontSize.sp,
        fontFamily = fontFamily,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier,
        textDecoration = textDecoration
    )
}