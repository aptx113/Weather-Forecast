package com.danteyu.studio.weatherforecast.data.source

/**
 * Created by George Yu on 2020/4/22.
 */
class DefaultWeatherRepository(
    private val remoteDataSource: WeatherDataSource,
    private val localDataSource: WeatherDataSource
) : WeatherRepository {

    override suspend fun get() {
        TODO("Not yet implemented")
    }
}