package com.danteyu.studio.weatherforecast.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.danteyu.studio.weatherforecast.MainViewModel
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository
import com.danteyu.studio.weatherforecast.home.HomeViewModel
import java.lang.IllegalArgumentException

/**
 * Created by George Yu on 2020/4/22.
 *
 * Factory for all ViewModels.
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val weatherRepository: WeatherRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = with(modelClass) {
        when {
            isAssignableFrom(MainViewModel::class.java) -> MainViewModel(weatherRepository)

            isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(weatherRepository)

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}