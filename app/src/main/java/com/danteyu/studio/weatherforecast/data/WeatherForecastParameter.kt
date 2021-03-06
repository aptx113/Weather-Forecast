package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by George Yu on 2020/4/24.
 */
@Parcelize
data class WeatherForecastParameter(
    val parameterName: String,
    val parameterUnit: String
) : Parcelable