package com.danteyu.studio.weatherforecast

import androidx.lifecycle.ViewModel
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository

/**
 * Created by George Yu on 2020/4/22.
 *
 * The [ViewModel] that is attached to the [MainActivity].
 */
class MainViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

}