package by.eapp.gosport.data.mappers

import by.eapp.gosport.data.local.models.CategoryItemEntity
import by.eapp.gosport.data.local.models.MenuItemEntity
import by.eapp.gosport.data.remote.model.CategoryDto
import by.eapp.gosport.data.remote.model.MenuItemDto
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem

fun MenuItemDto.toMenuItem(): MenuItem {
    val ingredients = mutableListOf<String?>()
    val fieldPrefix = "ingredient"
    val fieldCount = 20
    val clazz = this.javaClass
    for (i in 1..fieldCount) {
        val fieldName = "$fieldPrefix$i"
        try {
            val field = clazz.getDeclaredField(fieldName)
            field.isAccessible = true
            val ingredient = field.get(this) as? String
            if (!ingredient.isNullOrBlank()) {
                ingredients.add(ingredient)
            }
        } catch (e: NoSuchFieldException) {

        } catch (e: IllegalAccessException) {

        }
    }

    return MenuItem(
        id = id,
        title = title,
        imageUrl = image,
        category = category,
        ingredients = ingredients
    )
}


fun MenuItemDto.toMenuItemEntity(): MenuItemEntity {
    val ingredients = mutableListOf<String?>()
    val fieldPrefix = "ingredient"
    val fieldCount = 20
    val clazz = this.javaClass
    for (i in 1..fieldCount) {
        val fieldName = "$fieldPrefix$i"
        try {
            val field = clazz.getDeclaredField(fieldName)
            field.isAccessible = true
            val ingredient = field.get(this) as? String
            if (!ingredient.isNullOrBlank()) {
                ingredients.add(ingredient)
            }
        } catch (e: NoSuchFieldException) {

        } catch (e: IllegalAccessException) {

        }
    }
    return MenuItemEntity(
        id = this.id.toInt(),
        name = title,
        category = category,
        description = ingredients.joinToString(", "),
        image = image
    )
}

fun MenuItem.toMenuItemEntity(): MenuItemEntity {
    return MenuItemEntity(
        id = this.id.toInt(),
        name = this.title,
        category = this.category,
        description = this.ingredients.joinToString(", "),
        image = this.imageUrl
    )
}

fun MenuItemEntity.toMenuItem(): MenuItem {
    return MenuItem(
        id = this.id.toString(),
        title = this.name,
        imageUrl = this.image,
        category = this.category,
        ingredients = this.description.split(", ")
    )
}

//Category mappers
fun CategoryItemEntity.toCategory(): Category {
    return Category(
        id = this.id.toString(),
        categoryName = this.categoryName
    )
}

fun Category.toCategoryItemEntity(): CategoryItemEntity {
    return CategoryItemEntity(
        id = this.id,
        categoryName = this.categoryName
    )
}

fun CategoryDto.toCategory(): Category {
    return Category(
        id = id,
        categoryName = categoryName
    )
}