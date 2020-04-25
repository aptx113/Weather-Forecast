package com.danteyu.studio.weatherforecast.data.source.remote

import com.danteyu.studio.weatherforecast.R
import com.danteyu.studio.weatherforecast.data.HomeItem
import com.danteyu.studio.weatherforecast.data.Result
import com.danteyu.studio.weatherforecast.data.Temperature
import com.danteyu.studio.weatherforecast.data.source.WeatherDataSource
import com.danteyu.studio.weatherforecast.network.WeatherApi
import com.danteyu.studio.weatherforecast.util.Logger
import com.danteyu.studio.weatherforecast.util.Util.getString
import com.danteyu.studio.weatherforecast.util.Util.isInternetAvailable

/**
 * Created by George Yu on 2020/4/22.
 */
object RemoteDataSource : WeatherDataSource {

    override suspend fun getWeatherForecast(): Result<List<HomeItem>> {
        if (!isInternetAvailable()) {
            return Result.Fail(getString(R.string.internet_not_connected))
        }
        // Get the Deferred object for our Retrofit request
        val getResultDeferred = WeatherApi.retrofitService.getWeatherForecastAsync()
        return try {
            // this will run on a thread managed by Retrofit
            val listResult = getResultDeferred.await()

            listResult.error?.let {
                return Result.Fail(it)
            }
            listResult.records?.let {
                return Result.Success(it.location[0].weatherElement[0].toHomeItems())
            }
            Result.Fail(getString(R.string.you_know_nothing))

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }

}