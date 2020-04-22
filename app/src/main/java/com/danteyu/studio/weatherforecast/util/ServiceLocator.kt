package com.danteyu.studio.weatherforecast.util

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.danteyu.studio.weatherforecast.data.source.DefaultWeatherRepository
import com.danteyu.studio.weatherforecast.data.source.WeatherDataSource
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository
import com.danteyu.studio.weatherforecast.data.source.local.LocalDataSource
import com.danteyu.studio.weatherforecast.data.source.remote.RemoteDataSource

/**
 * Created by George Yu on 2020/4/22.
 *
 * A Service Locator for the [WeatherRepository].
 */
object ServiceLocator {

    @Volatile
    var weatherRepository: WeatherRepository? = null
        @VisibleForTesting set

    fun provideRepository(context: Context): WeatherRepository {
        synchronized(this) {
            return weatherRepository ?: createWeatherRepository(context)
        }
    }

    private fun createWeatherRepository(context: Context): WeatherRepository {
        return DefaultWeatherRepository(
            RemoteDataSource, createLocalDataSource(context)
        )
    }

    private fun createLocalDataSource(context: Context): WeatherDataSource {
        return LocalDataSource(context)
    }
}
