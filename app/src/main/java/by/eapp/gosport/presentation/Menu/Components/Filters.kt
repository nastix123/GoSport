package by.eapp.gosport.presentation.Menu.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.eapp.gosport.presentation.Menu.CustomText
import by.eapp.gosport.ui.theme.SelectedChip
import by.eapp.gosport.ui.theme.SelectedItem
import by.eapp.gosport.ui.theme.UnselectedChip
import by.eapp.gosport.ui.theme.secondaryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterRow(
    filters: List<String>,
) {
    var selectedChip by rememberSaveable {
        mutableStateOf("")
    }

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(filters) { item ->
            FilterChip(
                modifier = Modifier.padding(horizontal = 6.dp),
                selected = (item == selectedChip),
                onClick = {
                    selectedChip = item

                },
                label = {
                    CustomText(
                        text = item,
                        color = if (item == selectedChip) SelectedItem else secondaryText
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = SelectedChip,
                    containerColor = Color.White,
                ),
                border = null,
                elevation = FilterChipDefaults.filterChipElevation(
                    elevation = 4.dp,
                    focusedElevation = 0.dp
                )
            )
        }
    }
}

@Preview
@Composable
fun filtersPreview() {

    FilterRow(filters = listOf("Футбол", "Хоккей", "Баскетбол"))
}