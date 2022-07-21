package com.plcoding.rabbitsapp.di

import com.plcoding.rabbitsapp.common.Constants.BASE_URL_DEVICE
import com.plcoding.rabbitsapp.data.remote.RabbitApi
import com.plcoding.rabbitsapp.data.repository.RabbitRepositoryImp
import com.plcoding.rabbitsapp.domain.repository.RabbitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRabbitApi(): RabbitApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_DEVICE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RabbitApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRabbitRepository(api: RabbitApi): RabbitRepository {
        return RabbitRepositoryImp(api)
    }
}