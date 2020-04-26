package com.danteyu.studio.weatherforecast

import androidx.lifecycle.LiveData
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
        _backToHome.value = null
    }
}