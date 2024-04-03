package by.eapp.gosport.presentation.Menu

import by.eapp.gosport.domain.model.MenuItem

sealed interface MenuUIState {
    data object Loading : MenuUIState
    data class Result(val dishes: List<MenuItem>) : MenuUIState
    data object Error : MenuUIState
}