package by.eapp.gosport.data.mappers

import by.eapp.gosport.data.remote.model.CategoryDto
import by.eapp.gosport.data.remote.model.MenuItemDto
import by.eapp.gosport.domain.model.Category
import by.eapp.gosport.domain.model.MenuItem

fun MenuItemDto.toMenuItem(): MenuItem {
    val ingredients = mutableListOf<String?>()
    for (i in 1..20) {
        val ingredient = this.javaClass.getDeclaredField("ingredient$i").get(this) as? String
        if (!ingredient.isNullOrBlank()) {
            ingredients.add(ingredient)
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

fun CategoryDto.toCategory(): Category {
    return Category(
        id = id,
        categoryName = categoryName
    )
}
