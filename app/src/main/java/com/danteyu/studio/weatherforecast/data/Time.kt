package com.danteyu.studio.weatherforecast.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.sql.Timestamp

/**
 * Created by George Yu on 2020/4/24.
 */
@Parcelize
data class Time(
    val startTime: Timestamp,
    val endTime: Timestamp,
    val parameter: WeatherParameter
):Parcelable