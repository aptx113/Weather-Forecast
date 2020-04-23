package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by George Yu on 2020/4/23.
 */
@Parcelize
data class WeatherForecastField(
    val id: String,
    val type: String
) : Parcelable