package com.danteyu.studio.weatherforecast.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.danteyu.studio.weatherforecast.data.Temperature
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository
import com.danteyu.studio.weatherforecast.detail.DetailViewModel

/**
 * Created by George Yu on 2020/4/25.
 *
 * Factory for all ViewModels which need [Temperature].
 */
@Suppress("UNCHECKED_CAST")
class TemperatureViewModelFactory constructor(
    private val weatherRepository: WeatherRepository,
    private val temperature: Temperature
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = with(modelClass) {
        when {
            isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(
                weatherRepository,
                temperature
            )

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}