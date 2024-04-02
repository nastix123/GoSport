package by.eapp.gosport.domain.use_cases

import androidx.paging.PagingData
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem
import by.eapp.gosport.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMenuUseCase @Inject constructor(
    private val repository: MenuRepository
) {
    suspend operator fun invoke(): Flow<PagingData<MenuItem>> = repository.getMenu()
}

class GetCategoriesUseCase @Inject constructor(
    private val repository: MenuRepository
) {
    suspend operator fun invoke(): Flow<List<Category>> = repository.getCategories()
}

data class UseCases(
    val getMenuUseCase: GetMenuUseCase,
    val getCategoriesUseCase: GetCategoriesUseCase
)
