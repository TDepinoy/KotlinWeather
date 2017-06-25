package com.tdepinoy.kotlinweather.core.model

data class ForecastItem(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int, val weather: List<Weather>, val speed: Float, val deg: Int, val cloud: Int)