package com.tdepinoy.kotlinweather

import android.app.Application
import com.github.ajalt.timberkt.Timber
import com.github.salomonbrys.kodein.*
import com.tdepinoy.kotlinweather.core.api.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class KotlinWeatherApp : Application(), KodeinAware {

    companion object {
        val API_KEY_QUERY_PARAMETER = "APPID"
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(timber.log.Timber.DebugTree())
        }
    }

    override val kodein by Kodein.lazy {

        bind<OkHttpClient>() with singleton {
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.d { "OkHttp $message" } })
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        var request = chain.request()
                        val url = request.url().newBuilder().addQueryParameter(API_KEY_QUERY_PARAMETER, BuildConfig.WEATHER_API_KEY).build()
                        request = request.newBuilder()
                                .url(url)
                                .build()
                        chain.proceed(request)
                    }
                    .addInterceptor(loggingInterceptor)
                    .build()
        }

        bind<Retrofit>() with singleton {
            val client: OkHttpClient = instance()
            Retrofit.Builder()
                    .client(client)
                    .baseUrl(BuildConfig.API_ENDPOINT)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
        }

        bind<WeatherApi>() with singleton {
            val retrofit: Retrofit = instance()
            retrofit.create(WeatherApi::class.java)
        }
    }
}