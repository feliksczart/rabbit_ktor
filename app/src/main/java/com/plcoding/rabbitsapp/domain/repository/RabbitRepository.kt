package com.plcoding.rabbitsapp.domain.repository

import com.plcoding.rabbitsapp.data.remote.dto.RabbitDto


interface RabbitRepository {

    suspend fun getRandomRabbit(): RabbitDto
}