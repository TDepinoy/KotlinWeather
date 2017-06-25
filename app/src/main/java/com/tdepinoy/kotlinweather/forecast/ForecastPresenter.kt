package com.tdepinoy.kotlinweather.forecast

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import com.tdepinoy.kotlinweather.core.api.WeatherApi
import com.tdepinoy.kotlinweather.core.model.Forecast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastPresenter(val kodein: Kodein, val view: ForecastContract.View) : ForecastContract.Presenter {

    val weatherApi: WeatherApi = kodein.instance()

    override fun fetchForecast() {
        weatherApi.dailyForecast("94043").enqueue(object : Callback<Forecast> {

            override fun onFailure(call: Call<Forecast>?, t: Throwable?) {
                view.showError()
            }

            override fun onResponse(call: Call<Forecast>?, response: Response<Forecast>?) {
                view.bindForecast(response!!.body()!!)
            }
        })
    }
}
