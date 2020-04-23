package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by George Yu on 2020/4/24.
 */
@Parcelize
data class WeatherParameter(
    val parameterName: String,
    val parameterUnit: String
) : Parcelable