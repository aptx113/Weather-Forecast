package com.danteyu.studio.weatherforecast.ext

import android.app.Activity
import android.widget.Toast
import com.danteyu.studio.weatherforecast.WeatherApplication
import com.danteyu.studio.weatherforecast.factory.ViewModelFactory

/**
 * Created by George Yu on 2020/4/22.
 *
 * Extension functions for Activity.
 */
fun Activity.getVmFactory(): ViewModelFactory {
    val repository = (applicationContext as WeatherApplication).weatherRepository
    return ViewModelFactory(repository)
}

fun Activity?.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).apply {
        show()
    }
}