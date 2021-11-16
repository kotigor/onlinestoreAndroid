package ru.konstantinov.onlinestore.domain.model

class CakeDetail(
    val id: Long?,
    val name: String,
    val calories: Double?,
    val image: String,
    val price: Double?,
    val weight: Double?,
    val description: String,
    val ingredients: List<String>?
) {
    companion object{
        fun emptyCakeDetail() = CakeDetail(null, "", null, "", null, null, "", null);
    }
}