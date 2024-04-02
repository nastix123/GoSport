package by.eapp.gosport.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import by.eapp.gosport.data.SafeApiRequest
import by.eapp.gosport.data.mappers.toCategory
import by.eapp.gosport.data.pagination.MenuPagingSource
import by.eapp.gosport.data.remote.ApiService
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem
import by.eapp.gosport.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : MenuRepository {
    override suspend fun getMenu(): Flow<PagingData<MenuItem>> {
        return Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 5),
            pagingSourceFactory = { MenuPagingSource(apiService) }
        ).flow
    }

    override suspend fun getCategories(): Flow<List<Category>> {
        return flow {
            val response = apiService.getCategories()
            if (response.isSuccessful) {
                val categories = response.body()?.map { it.toCategory() } ?: emptyList()
                emit(categories)
            } else {
                throw HttpException(response)
            }
        }
    }

}