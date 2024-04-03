package by.eapp.gosport.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "menu")
data class MenuItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val category: String,
    val description: String,
    val image: String
)
