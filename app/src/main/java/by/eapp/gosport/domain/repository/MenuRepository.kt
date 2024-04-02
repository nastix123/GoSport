package by.eapp.gosport.domain.repository

import androidx.paging.PagingData
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    suspend fun getMenu(): Flow<PagingData<MenuItem>>

    suspend fun getCategories(): Flow<List<Category>>
}