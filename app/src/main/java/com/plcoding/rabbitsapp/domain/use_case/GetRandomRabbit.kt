package com.plcoding.rabbitsapp.domain.use_case

import com.plcoding.rabbitsapp.common.Resource
import com.plcoding.rabbitsapp.data.remote.dto.toRabbit
import com.plcoding.rabbitsapp.domain.model.Rabbit
import com.plcoding.rabbitsapp.domain.repository.RabbitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRandomRabbit @Inject constructor(
    private val repository: RabbitRepository
){

    operator fun invoke(): Flow<Resource<Rabbit>> = flow {
        try {
            emit(Resource.Loading<Rabbit>())
            val rabbit = repository.getRandomRabbit().toRabbit()
            emit(Resource.Success<Rabbit>(rabbit))
        } catch (e: HttpException) {
            emit(Resource.Error<Rabbit>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<Rabbit>("Couldn't reach server. Check your internet connection."))
        }
    }
}