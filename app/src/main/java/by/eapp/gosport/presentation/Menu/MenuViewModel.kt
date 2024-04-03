package by.eapp.gosport.presentation.Menu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem
import by.eapp.gosport.domain.use_cases.GetCategoriesUseCase
import by.eapp.gosport.domain.use_cases.GetMenuUseCase
import by.eapp.gosport.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject


@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getMenuUseCase: GetMenuUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {
    private companion object {
        val TAG: String = MenuViewModel::class.java.name
    }

    private val _dishes: MutableStateFlow<PagingData<MenuItem>> = MutableStateFlow(PagingData.empty())
    val dishes: MutableStateFlow<PagingData<MenuItem>> get() = _dishes

    private val _categories: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val categories: MutableStateFlow<List<String>> get() = _categories

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    getCategories()
                    getMenu()

                } catch (e: Exception) {
                    Log.e(TAG, "Error loading data", e)
                }
            }
        }
    }

    private suspend fun getCategories() {
        getCategoriesUseCase()
            .distinctUntilChanged()
            .collect { categories ->
                _categories.value = categories.map { it.categoryName }
                Log.d(TAG, "Categories loaded successfully")
            }

    }

    private suspend fun getMenu() {
        getMenuUseCase()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect { menu ->
                _dishes.value = menu
                Log.d(TAG, "Menu loaded successfully")
            }
    }


}