package com.tdepinoy.kotlinweather.core.model

data class Forecast(val city: City, val cod: String, val message: String, val cnt: Int, val list: List<ForecastItem>)