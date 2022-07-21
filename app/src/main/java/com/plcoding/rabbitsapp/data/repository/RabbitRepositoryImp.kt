package com.plcoding.rabbitsapp.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.plcoding.rabbitsapp.data.remote.RabbitApi
import com.plcoding.rabbitsapp.data.remote.dto.RabbitDto
import com.plcoding.rabbitsapp.domain.repository.RabbitRepository
import javax.inject.Inject

class RabbitRepositoryImp @Inject constructor(
    private val api: RabbitApi
) : RabbitRepository {

    override suspend fun getRandomRabbit(): RabbitDto {
        val rabbit = api.getRandomRabbit()
        Log.i(TAG, "getRandomRabbit: $rabbit")
        return rabbit
    }
}