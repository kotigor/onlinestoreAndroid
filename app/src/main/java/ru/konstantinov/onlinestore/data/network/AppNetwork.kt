package ru.konstantinov.onlinestore.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.konstantinov.onlinestore.data.network.services.CakesService
import ru.konstantinov.onlinestore.data.network.services.CakesServiceApi

internal object AppNetwork {
    private val gson = GsonBuilder().create()

    private val okHttpClient= OkHttpClient().newBuilder().build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://192.168.1.2:8080/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val cakesService by lazy{
        val cakesServiceApi = retrofit.create(CakesServiceApi::class.java)
        CakesService(cakesServiceApi)
    }
}