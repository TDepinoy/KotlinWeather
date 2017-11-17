package com.tdepinoy.kotlinweather.forecast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.appKodein
import com.tdepinoy.kotlinweather.R
import com.tdepinoy.kotlinweather.core.model.Forecast
import kotlinx.android.synthetic.main.activity_forecast.*
import org.jetbrains.anko.toast

class ForecastActivity : AppCompatActivity(), ForecastContract.View, KodeinInjected {

    override val injector = KodeinInjector()

    private val presenter: ForecastContract.Presenter by injector.with<ForecastContract.View>(this).instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        injector.inject(appKodein())
        forecast_recycler_view.layoutManager = LinearLayoutManager(this)
        presenter.fetchForecast()
    }

    override fun showError() {
        toast("Une erreur est survennue")
    }

    override fun bindForecast(forecast: Forecast) {
        forecast_recycler_view.adapter = ForecastAdapter(forecast.list)
    }
}
