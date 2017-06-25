package com.tdepinoy.kotlinweather.core.api

import com.tdepinoy.kotlinweather.core.model.Forecast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast/daily")
    fun dailyForecast(@Query("q") cityCode: String) : Call<Forecast>
}