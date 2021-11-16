package ru.konstantinov.onlinestore.data.network.services

import retrofit2.Response
import ru.konstantinov.onlinestore.data.network.model.CakeDetailNet
import ru.konstantinov.onlinestore.data.network.model.CakesNet

internal class CakesService(
    private val apiService: CakesServiceApi
) {

    suspend fun getCakes(): Response<CakesNet> = apiService.getCakes()
    suspend fun getCake(id: Long): Response<CakeDetailNet> = apiService.getCake(id)
}