package com.tdepinoy.kotlinweather.forecast

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import com.tdepinoy.kotlinweather.core.api.WeatherApi
import com.tdepinoy.kotlinweather.core.model.Forecast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ForecastPresenter(val kodein: Kodein, val view: ForecastContract.View) : ForecastContract.Presenter {

    val weatherApi: WeatherApi = kodein.instance()

    override fun fetchForecast() {
        weatherApi.dailyForecast("94043")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            forecast: Forecast ->
                            view.bindForecast(forecast)
                        },
                        {
                            view.showError()
                        }
                )
    }
}
