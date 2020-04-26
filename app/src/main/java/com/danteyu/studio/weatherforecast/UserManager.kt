package com.danteyu.studio.weatherforecast

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by George Yu on 2020/4/25.
 */

object UserManager {

    private const val USER_DATA = "user_data"
    private const val USER_VISITATION = "visitation"

    var prefs: SharedPreferences =
        WeatherApplication.instance.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)

    var visitation: Long? = null
        get() = prefs.getLong(USER_VISITATION, 0)
        set(value) {
            field = when (value) {
                null -> {
                    prefs.edit().remove(USER_VISITATION).apply()
                    null
                }
                else -> {
                    prefs.edit().putLong(USER_VISITATION, value).apply()
                    value
                }
            }
        }
}