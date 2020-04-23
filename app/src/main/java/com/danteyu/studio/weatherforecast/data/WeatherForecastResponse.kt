package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by George Yu on 2020/4/23.
 */
@Parcelize
data class WeatherForecastResponse(
    val error: String? = null,
    @Json(name = "success")
    val response: Boolean? = null,
    val result: WeatherForecastResult? = null,
    val records: WeatherForecastRecords? = null
) : Parcelable