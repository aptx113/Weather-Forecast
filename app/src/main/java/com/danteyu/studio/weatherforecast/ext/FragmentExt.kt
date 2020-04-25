package com.danteyu.studio.weatherforecast.ext

import androidx.fragment.app.Fragment
import com.danteyu.studio.weatherforecast.WeatherApplication
import com.danteyu.studio.weatherforecast.data.Temperature
import com.danteyu.studio.weatherforecast.factory.TemperatureViewModelFactory
import com.danteyu.studio.weatherforecast.factory.ViewModelFactory

/**
 * Created by George Yu on 2020/4/22.
 *
 * Extension functions for Fragment.
 */
fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as WeatherApplication).weatherRepository
    return ViewModelFactory(repository)
}

fun Fragment.getVmFactory(temperature: Temperature): TemperatureViewModelFactory {
    val repository = (requireContext().applicationContext as WeatherApplication).weatherRepository
    return TemperatureViewModelFactory(repository, temperature)
}