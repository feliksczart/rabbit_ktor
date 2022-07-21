package com.plcoding.rabbitsapp.data.remote

import com.plcoding.rabbitsapp.data.remote.dto.RabbitDto
import retrofit2.http.GET

interface RabbitApi {

    @GET("/randomrabbit")
    suspend fun getRandomRabbit(): RabbitDto
}