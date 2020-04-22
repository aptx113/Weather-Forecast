package com.danteyu.studio.weatherforecast.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository
import com.danteyu.studio.weatherforecast.network.LoadApiStatus
import com.danteyu.studio.weatherforecast.util.Logger

/**
 * Created by George Yu on 2020/4/23.
 *
 * The [ViewModel] that is attached to the [HomeFragment].
 */
class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    // status: The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<LoadApiStatus>()

    val status: LiveData<LoadApiStatus>
        get() = _status

    // error: The internal MutableLiveData that stores the error of the most recent request
    private val _error = MutableLiveData<String>()

    val error: LiveData<String>
        get() = _error

    // status for the loading notes
    private val _refreshStatus = MutableLiveData<Boolean>()

    val refreshStatus: LiveData<Boolean>
        get() = _refreshStatus

    init {
        Logger.i("------------------------------------")
        Logger.i("[${this::class.simpleName}]${this}")
        Logger.i("------------------------------------")

    }

    fun refresh() {
        if (_status.value != LoadApiStatus.LOADING) {
        }

    }
}