package com.danteyu.studio.weatherforecast.util

import com.danteyu.studio.weatherforecast.R
import com.danteyu.studio.weatherforecast.util.Util.getString

/**
 * Created by George Yu on 2020/4/22.
 */
enum class CurrentFragmentType(val value: String) {
    HOME(getString(R.string.weather_forecast)),
    DETAIL("")
}