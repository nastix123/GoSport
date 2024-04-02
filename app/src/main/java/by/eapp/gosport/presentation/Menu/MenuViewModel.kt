package by.eapp.gosport.presentation.Menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import by.eapp.gosport.domain.model.MenuItem
import by.eapp.gosport.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MenuViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {
    private companion object {
        val TAG: String = MenuViewModel::class.java.name
    }
    init {
        viewModelScope.launch {
            getMenu()
        }
    }
    private val _dishes: MutableStateFlow<PagingData<MenuItem>> =
        MutableStateFlow(PagingData.empty())
    val dishes: MutableStateFlow<PagingData<MenuItem>> get() = _dishes


    private suspend fun getMenu() {
        useCases
            .getMenuUseCase()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect {
            _dishes.value = it
        }
    }


}