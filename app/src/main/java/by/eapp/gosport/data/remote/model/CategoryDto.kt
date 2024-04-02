package by.eapp.gosport.data.remote.model

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val categoryName: String
)
