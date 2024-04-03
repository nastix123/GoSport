package by.eapp.gosport.presentation.Menu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem
import by.eapp.gosport.domain.use_cases.GetCategoriesUseCase
import by.eapp.gosport.domain.use_cases.GetMenuUseCase
import by.eapp.gosport.domain.use_cases.UseCases
import by.eapp.gosport.domain.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
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

    private val _dishes: MutableStateFlow<Resource<List<MenuItem>>> = MutableStateFlow(Resource.Loading())
    val dishes: MutableStateFlow<Resource<List<MenuItem>>> get() = _dishes

    private val _categories: MutableStateFlow<Resource<List<String>>> = MutableStateFlow(Resource.Loading())
    val categories: MutableStateFlow<Resource<List<String>>> get() = _categories


    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory: MutableStateFlow<String?> = _selectedCategory


    init {
       // loadData()
    }

//    private fun loadData() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                try {
//                    getCategories()
//                    getMenu()
//
//                } catch (e: Exception) {
//                    Log.e(TAG, "Error loading data", e)
//                }
//            }
//        }
//    }

    fun getMeals() {
        viewModelScope.launch {
            combine(
                getMenuUseCase.getMenuFromDb(),
                _dishes,
                _selectedCategory
            ) { menuFromDb, menuFromApi, selectedCategory ->

            }.collect()
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            combine(
                getCategoriesUseCase.getCategoriesFromDb(),
                _categories,
                _selectedCategory
            ) { categoriesFromDb, categories, selectedCategory ->

            }.collect()
        }
    }
    fun filterByCategory(category: String) {
        viewModelScope.launch {
            val menu = getMenuUseCase.getMenuFromDb().firstOrNull()
            menu?.let { nonNullMenu ->
                val filteredMenu = nonNullMenu.filter { it.category == category }
                _dishes.value = filteredMenu
            }
        }
    }


}