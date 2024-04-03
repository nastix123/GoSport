package by.eapp.gosport.data.repository

import android.util.Log
import by.eapp.gosport.data.local.Database
import by.eapp.gosport.data.mappers.toCategory
import by.eapp.gosport.data.mappers.toCategoryItemEntity
import by.eapp.gosport.data.mappers.toMenuItem
import by.eapp.gosport.data.mappers.toMenuItemEntity
import by.eapp.gosport.data.remote.ApiService
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem
import by.eapp.gosport.domain.repository.MenuRepository
import by.eapp.gosport.domain.utlis.Resource
import by.eapp.gosport.domain.utlis.Resource.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val database: Database,
) : MenuRepository {

    companion object {
        val TAG: String = MenuRepositoryImpl::class.java.name
    }

    override suspend fun getMenuFromApi(): Resource<Flow<List<MenuItem>>> {
        return try {
            val response = apiService.getMenu()
            if (response.isSuccessful) {
                val mealResponse = response.body()
                val menuItems = mealResponse?.meals?.map { menuItemDto ->
                    menuItemDto.toMenuItem()
                } ?: emptyList()

                database.menuDao.insertAllMenu(menuItems.map { it.toMenuItemEntity() })

                val menuFlow = database.menuDao.getMenu().map { it.map { it.toMenuItem() } }
                Log.d(TAG, "Fetched menu from API")
                Success(menuFlow)

            } else {
                Error("Failed to fetch menu from API")
            }
        } catch (e: Exception) {
            Error(msg = e.message.toString())
        }
    }

    override suspend fun getMenuFromDb(): Flow<List<MenuItem>> {
        return database.menuDao.getMenu().map { it.map { it.toMenuItem() } }

    }

    override suspend fun getCategoriesFromApi(): Resource<Flow<List<Category>>> {
        return try {
            val response = apiService.getCategories()
            if (response.isSuccessful) {
                val categoryResponse = response.body()
                val categories = categoryResponse?.categories?.map { categoryItemDto ->
                    categoryItemDto.toCategory()
                } ?: emptyList()

                database.menuDao.insertAllCategories(categories.map { it.toCategoryItemEntity() })

                val categoriesFlow = database.menuDao.getCategories().map { it.map { it.toCategory() } }
                Log.d(TAG, "Fetched categories from API")
                Success(categoriesFlow)
            } else {
                Error("Failed to fetch categories from API")
            }
        } catch (e: Exception) {
            Error(msg = e.message.toString())
        }
    }

    override suspend fun getCategoriesFromDb(): Flow<List<Category>> {
        return database.menuDao.getCategories().map { it.map { it.toCategory() } }
    }




//    override suspend fun getMenu(): Flow<PagingData<MenuItem>> {
//        return Pager(
//            config = PagingConfig(pageSize = 20, prefetchDistance = 5),
//            pagingSourceFactory = { MenuPagingSource(apiService) }
//        ).flow
//    }
//
//    override suspend fun getCategories(): Flow<List<Category>> {
//        return flow {
//            val response = apiService.getCategories()
//            if (response.isSuccessful) {
//                val categories = response.body()?.categories?.map { it.toCategory() } ?: emptyList()
//                emit(categories)
//                Log.d(TAG, "api request categories is successful")
//            } else {
//                throw HttpException(response)
//                Log.d(TAG, "api request categories is not successful")
//            }
//        }
//    }

}
