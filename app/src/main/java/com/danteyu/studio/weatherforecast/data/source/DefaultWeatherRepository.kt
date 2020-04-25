package com.danteyu.studio.weatherforecast.data.source

import com.danteyu.studio.weatherforecast.data.HomeItem
import com.danteyu.studio.weatherforecast.data.Result
import com.danteyu.studio.weatherforecast.data.Temperature

/**
 * Created by George Yu on 2020/4/22.
 */
class DefaultWeatherRepository(
    private val remoteDataSource: WeatherDataSource,
    private val localDataSource: WeatherDataSource
) : WeatherRepository {

    override suspend fun getWeatherForecast():Result<List<HomeItem>> {
        return remoteDataSource.getWeatherForecast()
    }
}