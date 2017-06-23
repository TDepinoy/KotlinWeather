package com.tdepinoy.kotlinweather

import android.app.Application
import com.github.salomonbrys.kodein.*
import com.tdepinoy.kotlinweather.core.api.WeatherApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class KotlinWeatherApp : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                    .client(OkHttpClient())
                    .baseUrl(BuildConfig.API_ENDPOINT)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
        }
        bind<WeatherApi>() with factory { retrofit: Retrofit -> retrofit.create(WeatherApi::class.java) }
    }
}