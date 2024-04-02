package by.eapp.gosport.data.remote.model

import com.google.gson.annotations.SerializedName

data class MenuItemDto(
    @SerializedName("idMeal")
    val id: String,
    @SerializedName("strMeal")
    val title: String,
    @SerializedName("strMealThumb")
    val image: String,
    @SerializedName("strCategory")
    val category: String,

    @SerializedName("strIngredient1")
    val ingredient1: String? = null,
    @SerializedName("strIngredient2")
    val ingredient2: String? = null,
    @SerializedName("strIngredient3")
    val ingredient3: String? = null,
    @SerializedName("strIngredient4")
    val ingredient4: String? = null,
    @SerializedName("strIngredient5")
    val ingredient5: String? = null,
    @SerializedName("strIngredient6")
    val ingredient6: String? = null,
    @SerializedName("strIngredient7")
    val ingredient7: String? = null,
    @SerializedName("strIngredient8")
    val ingredient8: String? = null,
    @SerializedName("strIngredient9")
    val ingredient9: String? = null,
    @SerializedName("strIngredient10")
    val ingredient10: String? = null,
    @SerializedName("strIngredient11")
    val ingredient11: String? = null,
    @SerializedName("strIngredient12")
    val ingredient12: String? = null,
    @SerializedName("strIngredient13")
    val ingredient13: String? = null,
    @SerializedName("strIngredient14")
    val ingredient14: String? = null,
    @SerializedName("strIngredient15")
    val ingredient15: String? = null,
    @SerializedName("strIngredient16")
    val ingredient16: String? = null,
    @SerializedName("strIngredient17")
    val ingredient17: String? = null,
    @SerializedName("strIngredient18")
    val ingredient18: String? = null,
    @SerializedName("strIngredient19")
    val ingredient19: String? = null,
    @SerializedName("strIngredient20")
    val ingredient20: String? = null,

    )
