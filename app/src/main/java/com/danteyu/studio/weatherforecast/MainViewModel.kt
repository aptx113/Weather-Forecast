package com.danteyu.studio.weatherforecast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository
import com.danteyu.studio.weatherforecast.util.CurrentFragmentType
import com.danteyu.studio.weatherforecast.util.Logger

/**
 * Created by George Yu on 2020/4/22.
 *
 * The [ViewModel] that is attached to the [MainActivity].
 */
class MainViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    // Record current fragment to support data binding
    val currentFragmentType = MutableLiveData<CurrentFragmentType>()

    init {
        Logger.i("------------------------------------")
        Logger.i("[${this::class.simpleName}]${this}")
        Logger.i("------------------------------------")

    }
}