package com.tdepinoy.kotlinweather.forecast

import com.tdepinoy.kotlinweather.core.model.Forecast

interface ForecastContract {
    interface View {
        fun showError()
        fun bindForecast(forecast: Forecast)
    }
    interface Presenter {
        fun fetchForecast()
    }
}