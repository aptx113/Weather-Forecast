package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by George Yu on 2020/4/23.
 */
@Parcelize
data class WeatherForecastResult(
    @Json(name = "resource_id")
    val resourceId: String,
    val fields: List<WeatherForecastField>
) : Parcelable