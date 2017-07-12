package com.tdepinoy.kotlinweather.forecast

import com.tdepinoy.kotlinweather.core.api.WeatherApi
import com.tdepinoy.kotlinweather.core.model.Forecast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ForecastPresenter(val view: ForecastContract.View, val weatherApi: WeatherApi) : ForecastContract.Presenter {


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
