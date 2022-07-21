package com.plcoding.rabbitsapp.presentation.screen.random_rabbit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RandomRabbitScreen(
    viewModel: RandomRabbitViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        state.rabbit?.let {
            Image(
                painter = rememberImagePainter(
                    data = state.rabbit.imageUrl,
                    builder = { crossfade(true) }
                ),
                contentDescription = "Rabbit"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.rabbit.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = state.rabbit.description)
            Spacer(modifier = Modifier.height(8.dp))
        }
        Button(
            onClick = viewModel::getRandomRabbit,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Next rabbit!")
        }
        Spacer(Modifier.height(8.dp))
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(CenterHorizontally)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}