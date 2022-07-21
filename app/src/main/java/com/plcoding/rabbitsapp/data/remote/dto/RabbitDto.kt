package com.plcoding.rabbitsapp.data.remote.dto

import com.plcoding.rabbitsapp.domain.model.Rabbit

data class RabbitDto(
    val name: String,
    val description: String,
    val imageUrl: String
)

fun RabbitDto.toRabbit(): Rabbit {
    return Rabbit(
        name = name,
        description = description,
        imageUrl = imageUrl
    )
}
