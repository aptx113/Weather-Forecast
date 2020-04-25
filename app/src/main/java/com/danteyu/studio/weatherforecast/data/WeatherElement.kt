package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import com.danteyu.studio.weatherforecast.R
import com.danteyu.studio.weatherforecast.util.Util.getDrawable
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
            it.forEach { temperature ->
                items.add(HomeItem.WeatherForecastData(temperature))
                items.add(HomeItem.Image(WeatherImage(getDrawable(R.drawable.icon_cwb))))
            }
        }

        return items
    }
}