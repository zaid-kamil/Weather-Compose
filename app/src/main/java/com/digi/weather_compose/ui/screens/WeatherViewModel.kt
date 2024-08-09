package com.digi.weather_compose.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digi.weather_compose.network.WeatherApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class WeatherState(
    val result: String = "",
)

class WeatherViewModel() : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    init{
        getWeatherData()
    }

    private fun getWeatherData() {
        viewModelScope.launch {
            val result = WeatherApi.retrofitService.getWeather(
                city = "lucknow",
                apiKey = "79edda4f3448c7e92b2289d3718af890"
            )
            _state.update { it.copy(result = result) }
        }
    }

}