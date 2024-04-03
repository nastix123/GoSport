package by.eapp.gosport.data.remote.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

    @SerializedName("categories")
    val categories: List<CategoryDto>
)
