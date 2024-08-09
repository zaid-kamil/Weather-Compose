package com.digi.weather_compose.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    state: WeatherState,
    onSettingClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        AnimatedVisibility(visible = state.result.isNotEmpty()) {
            Text(
                text = state.result.trimIndent(),
                fontFamily = FontFamily.Monospace,
                fontSize = 22.sp,
                lineHeight = 30.sp,
            )
        }
    }
}