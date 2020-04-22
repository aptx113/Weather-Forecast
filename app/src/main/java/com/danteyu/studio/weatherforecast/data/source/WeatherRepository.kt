package com.danteyu.studio.weatherforecast.data.source

/**
 * Created by George Yu on 2020/4/22.
 */
interface WeatherRepository {
    suspend fun get()
}