package by.eapp.gosport.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import by.eapp.gosport.data.local.models.CategoryItemEntity
import by.eapp.gosport.data.local.models.MenuItemEntity
import by.eapp.gosport.domain.model.Category
import kotlinx.coroutines.flow.Flow


@Dao
interface MenuDao {
    @Query("Select * From category")
    fun getCategories(): Flow<List<CategoryItemEntity>>

    @Query("SELECT * FROM menu")
    fun getMenu(): Flow<List<MenuItemEntity>>

    @Transaction
    suspend fun insertAllMenu(menu: List<MenuItemEntity>){
        menu.forEach { insertMenuItemEntity(it) }
    }

    @Transaction
    suspend fun insertAllCategories(categories: List<CategoryItemEntity>){
        categories.forEach { insertCategory(it) }
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMenuItemEntity(menuItemEntity: MenuItemEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: CategoryItemEntity)

//    @Query("SELECT * FROM category")
//    fun pagingCategorySource(): PagingSource<Int, CategoryItemEntity>
//    @Query("Select * From menu")
//    fun getMeals(): Flow<List<MenuItemEntity>>




}