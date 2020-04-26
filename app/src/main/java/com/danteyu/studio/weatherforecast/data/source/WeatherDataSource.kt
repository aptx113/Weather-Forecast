package com.danteyu.studio.weatherforecast.data.source

import com.danteyu.studio.weatherforecast.data.HomeItem
import com.danteyu.studio.weatherforecast.data.Result
import com.danteyu.studio.weatherforecast.data.Temperature

/**
 * Created by George Yu on 2020/4/22.
 */
interface WeatherDataSource {

    suspend fun getWeatherForecast():Result<List<HomeItem>>
}