package com.danteyu.studio.weatherforecast.data.source.local

import android.content.Context
import com.danteyu.studio.weatherforecast.data.Result
import com.danteyu.studio.weatherforecast.data.Time
import com.danteyu.studio.weatherforecast.data.source.WeatherDataSource

/**
 * Created by George Yu on 2020/4/22.
 */
class LocalDataSource(val context: Context):WeatherDataSource{

    override suspend fun getWeatherForecast():Result<List<Time>> {
        TODO("Not yet implemented")
    }
}