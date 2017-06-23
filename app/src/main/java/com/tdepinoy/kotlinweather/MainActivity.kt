package com.tdepinoy.kotlinweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.tdepinoy.kotlinweather.forecast.ForecastAdapter
import com.tdepinoy.kotlinweather.forecast.ForecastContract
import com.tdepinoy.kotlinweather.forecast.ForecastPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ForecastContract.View {

    private val APP_ID = "bcc5d3dbfaaff1e00f25ab545104c9ba"

    private val items = listOf("Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7")

    private lateinit var presenter: ForecastPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ForecastPresenter(this)
        main_recycler_view.layoutManager = LinearLayoutManager(this)
        main_recycler_view.adapter = ForecastAdapter(items)
    }
}
