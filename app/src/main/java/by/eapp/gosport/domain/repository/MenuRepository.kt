package by.eapp.gosport.domain.repository

import androidx.paging.PagingData
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem
import by.eapp.gosport.domain.utlis.Resource
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    suspend fun getMenuFromApi(): Resource<Flow<List<MenuItem>>>
    suspend fun getMenuFromDb(): Flow<List<MenuItem>>
    suspend fun getCategoriesFromApi(): Resource<Flow<List<Category>>>
    suspend fun getCategoriesFromDb(): Flow<List<Category>>
}