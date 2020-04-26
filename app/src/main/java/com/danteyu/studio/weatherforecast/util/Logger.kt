package com.danteyu.studio.weatherforecast.util

import android.util.Log
import com.danteyu.studio.weatherforecast.BuildConfig

/**
 * Created by George Yu on 2020/4/22.
 */
object Logger {

    private const val TAG = "Dante-Weather Forecast"

    fun v(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.v(TAG, content) }
    fun d(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.d(TAG, content) }
    fun i(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.i(TAG, content) }
    fun w(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.w(TAG, content) }
    fun e(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.e(TAG, content) }

}