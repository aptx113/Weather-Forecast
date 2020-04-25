package com.danteyu.studio.weatherforecast.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danteyu.studio.weatherforecast.data.Temperature
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository
import com.danteyu.studio.weatherforecast.util.Logger

/**
 * Created by George Yu on 2020/4/25.
 */
class DetailViewModel(
    private val weatherRepository: WeatherRepository,
    private val argument: Temperature
) : ViewModel() {

    private val _temperature = MutableLiveData<Temperature>().apply { value = argument }

    val temperature: LiveData<Temperature>
        get() = _temperature

    private val _backToHome = MutableLiveData<Boolean>()

    val backToHome: LiveData<Boolean>
        get() = _backToHome

    init {
        Logger.i("------------------------------------")
        Logger.i("[${this::class.simpleName}]${this}")
        Logger.i("------------------------------------")

    }

    fun backToHome() {
        _backToHome.value = true
    }

    fun onBackToHome() {
        _backToHome.value = false
    }
}