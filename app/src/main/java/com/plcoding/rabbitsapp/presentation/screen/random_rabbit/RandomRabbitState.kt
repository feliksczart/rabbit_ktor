package com.plcoding.rabbitsapp.presentation.screen.random_rabbit

import com.plcoding.rabbitsapp.domain.model.Rabbit

data class RandomRabbitState(
    val isLoading: Boolean = false,
    val rabbit: Rabbit? = null,
    val error: String = ""
)