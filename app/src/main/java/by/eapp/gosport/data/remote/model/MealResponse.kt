package by.eapp.gosport.data.remote.model

import com.google.gson.annotations.SerializedName

data class MealResponse(

    @SerializedName("meals")
    val meals: List<MenuItemDto>
)
