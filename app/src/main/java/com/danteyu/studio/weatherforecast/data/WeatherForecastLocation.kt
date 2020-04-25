package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by George Yu on 2020/4/23.
 */
@Parcelize
data class WeatherForecastLocation(
    val locationName: String,
    val weatherElement: List<WeatherElement>
) : Parcelable