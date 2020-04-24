package com.danteyu.studio.weatherforecast.data.source

import com.danteyu.studio.weatherforecast.data.Result
import com.danteyu.studio.weatherforecast.data.Time

/**
 * Created by George Yu on 2020/4/22.
 */
interface WeatherDataSource {

    suspend fun getWeatherForecast():Result<List<Time>>
}