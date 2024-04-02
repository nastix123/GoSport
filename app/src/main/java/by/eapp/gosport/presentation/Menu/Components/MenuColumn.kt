package by.eapp.gosport.presentation.Menu.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import by.eapp.gosport.domain.model.MenuItem
import by.eapp.gosport.presentation.utils.Const


@Composable
fun MenuColumn(
    listOfDishes: LazyPagingItems<MenuItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        listOfDishes.apply {
            when {
                loadState.refresh is androidx.paging.LoadState.Loading -> {
                    item {  }
                }
                loadState.refresh is androidx.paging.LoadState.Error -> {
                    val error = listOfDishes.loadState.refresh as LoadState.Error
                    item {
                        ErrorMessage(
                            message = error.error.localizedMessage ?: "Error",
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { retry() }
                        )
                    }
                }
                loadState.append is androidx.paging.LoadState.Loading -> {
                    items(listOfDishes.itemCount) { index ->
                        listOfDishes[index]?.let { menuItem ->
                            by.eapp.gosport.presentation.Menu.Components.MenuItem(
                                title = menuItem.title,
                                price = Const.PRICE,
                                description = menuItem.ingredients,
                                imageUrl = menuItem.imageUrl
                            )
                        }
                    }
                }
                loadState.append is LoadState.Error -> {
                    val error = listOfDishes.loadState.append as LoadState.Error
                    item {
                        ErrorMessage(
                            message = error.error.localizedMessage ?: "Error",
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { retry() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorMessage(message: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(text = message)
    }
}