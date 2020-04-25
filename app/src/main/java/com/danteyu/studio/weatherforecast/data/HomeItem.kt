package com.danteyu.studio.weatherforecast.data

/**
 * Created by George Yu on 2020/4/24.
 */
sealed class HomeItem {

    abstract val id: String

    data class Image(val image: WeatherImage) : HomeItem() {
        override val id: String = ""
    }

    data class WeatherForecastData(val temperature: Temperature) : HomeItem() {
        override val id: String
            get() = temperature.startTime
    }

}