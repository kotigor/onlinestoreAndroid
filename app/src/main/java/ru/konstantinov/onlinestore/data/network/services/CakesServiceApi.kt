package ru.konstantinov.onlinestore.data.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.konstantinov.onlinestore.data.network.model.CakeDetailNet
import ru.konstantinov.onlinestore.data.network.model.CakesNet

internal interface CakesServiceApi {

    @GET("cakes")
    suspend fun getCakes(): Response<CakesNet>

    @GET("cake/{id}")
    suspend fun getCake(@Path("id") id : Long) : Response<CakeDetailNet>

}