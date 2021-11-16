package ru.konstantinov.onlinestore.data.network.model

import java.math.BigDecimal

data class CakeNet(
    val id: Long?,
    val name: String,
    val calories: BigDecimal?,
    val image: String,
    val price: BigDecimal?,
    val weight: BigDecimal?
) {
}