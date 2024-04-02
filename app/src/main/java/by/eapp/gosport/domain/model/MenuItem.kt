package by.eapp.gosport.domain.model

data class MenuItem(
    val id: String,
    val title: String,
    val imageUrl: String,
    val category: String,

    val ingredients: List<String?>
)

