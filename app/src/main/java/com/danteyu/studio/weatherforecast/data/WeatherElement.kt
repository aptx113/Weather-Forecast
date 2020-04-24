package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by George Yu on 2020/4/24.
 */
@Parcelize
data class WeatherElement(
    val elementName: String,
    @Json(name = "time")
    val temperatureList: List<Temperature>? = null
) : Parcelable {

    fun toHomeItems(): List<HomeItem> {
        val items = mutableListOf<HomeItem>()

        temperatureList?.let {
            for (temperature in it) {
                items.add(HomeItem.WeatherForecastData(temperature))
            }
        }
        return items
    }
}