package ru.konstantinov.onlinestore.data.network.model

import java.math.BigDecimal

data class CakeDetailNet(
    val id: Long?,
    val name: String,
    val calories: BigDecimal?,
    val image: String,
    val price: BigDecimal?,
    val weight: BigDecimal?,
    val description: String,
    val composition: List<String>?
) {
    companion object {
        fun emptyCakeDetailNet() = CakeDetailNet(
            null,
            "", null,
            "", null, null, "", null
        )
    }
    }