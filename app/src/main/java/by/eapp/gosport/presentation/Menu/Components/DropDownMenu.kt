package by.eapp.gosport.presentation.Menu.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import by.eapp.gosport.presentation.Menu.CustomText

@Composable
fun DropdownList(
    itemList: List<String>,
    selectedIndex: Int,
    modifier: Modifier,
    onItemClick: (Int) -> Unit,
    icon: ImageVector,
    showDropdown: Boolean
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .clickable { /* Toggle dropdown visibility */ }
                .padding(8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row() {
                CustomText(
                    text = itemList[selectedIndex],
                    color = Color.Black
                )
                Icon(
                    imageVector = icon,
                    contentDescription = "Dropdown Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        if (showDropdown) {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .padding(4.dp)
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    itemList.forEachIndexed { index, item ->
                        CustomText(
                            text = item,
                            modifier = Modifier
                                .clickable {
                                    onItemClick(index)
                                    // Close dropdown after item selection
                                }
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}
