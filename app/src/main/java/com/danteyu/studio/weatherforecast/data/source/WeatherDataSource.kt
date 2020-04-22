package com.danteyu.studio.weatherforecast.data.source

/**
 * Created by George Yu on 2020/4/22.
 */
interface WeatherDataSource {

    suspend fun get()
}