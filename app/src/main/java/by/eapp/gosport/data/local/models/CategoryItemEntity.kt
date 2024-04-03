package by.eapp.gosport.data.local.models

import androidx.room.Entity


@Entity(tableName = "category")
data class CategoryItemEntity(
    val id: String,
    val categoryName: String
)
