package com.tdepinoy.kotlinweather.core.api

import retrofit2.http.GET

interface WeatherApi {

    @GET("/forecast/daily")
    fun dailyForecast()
}