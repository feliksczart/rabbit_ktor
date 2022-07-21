package com.plcoding.rabbitsapp.presentation.screen.random_rabbit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.rabbitsapp.common.Resource
import com.plcoding.rabbitsapp.domain.use_case.GetRandomRabbit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RandomRabbitViewModel @Inject constructor(
    private val getRandomRabbitUC: GetRandomRabbit
) : ViewModel() {


    private val _state = mutableStateOf(RandomRabbitState())
    val state: State<RandomRabbitState> = _state

    init {
        getRandomRabbit()
    }

    fun getRandomRabbit() {
        getRandomRabbitUC().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RandomRabbitState(rabbit = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        RandomRabbitState(error = result.message ?: "An unexpected error occured.")
                }
                is Resource.Loading -> {
                    _state.value = RandomRabbitState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}