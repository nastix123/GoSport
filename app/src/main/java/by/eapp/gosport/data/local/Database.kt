package by.eapp.gosport.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import by.eapp.gosport.data.local.models.CategoryItemEntity
import by.eapp.gosport.data.local.models.MenuItemEntity


@Database(entities = [
    MenuItemEntity::class,
    CategoryItemEntity::class
                     ], version = 1)
abstract class Database(): RoomDatabase() {
    abstract val menuDao: MenuDao
}