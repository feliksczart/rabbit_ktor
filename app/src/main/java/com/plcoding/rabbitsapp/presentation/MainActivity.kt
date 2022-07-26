package com.plcoding.rabbitsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.plcoding.rabbitsapp.presentation.screen.random_rabbit.RandomRabbitScreen
import com.plcoding.rabbitsapp.presentation.theme.RabbitsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabbitsAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    RandomRabbitScreen()
                }
            }
        }
    }
}