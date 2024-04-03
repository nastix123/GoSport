package by.eapp.gosport.data.mappers

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
            // Обработка отсутствия поля
        } catch (e: IllegalAccessException) {
            // Обработка ошибки доступа к полю
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
