package ru.konstantinov.onlinestore.domain.model

data class Cake(
    val id: Long?,
    val name: String,
    val calories: Double?,
    val image: String,
    val price: Double?,
    val weight: Double?
) {
    companion object{
        fun emptyCake() = Cake(null, "", null, "", null, null);
    }
}