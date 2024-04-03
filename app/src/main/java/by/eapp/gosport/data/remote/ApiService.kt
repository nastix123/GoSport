package by.eapp.gosport.data.remote

import by.eapp.gosport.data.remote.model.CategoryDto
import by.eapp.gosport.data.remote.model.CategoryResponse
import by.eapp.gosport.data.remote.model.MealResponse
import by.eapp.gosport.data.remote.model.MenuItemDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php?s")
    suspend fun getMenu(): Response<MealResponse>

    @GET("categories.php")
    suspend fun getCategories(): Response<CategoryResponse>
}
