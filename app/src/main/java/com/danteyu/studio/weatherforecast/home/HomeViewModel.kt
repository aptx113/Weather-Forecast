package com.danteyu.studio.weatherforecast.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danteyu.studio.weatherforecast.R
import com.danteyu.studio.weatherforecast.data.HomeItem
import com.danteyu.studio.weatherforecast.data.Result
import com.danteyu.studio.weatherforecast.data.Temperature
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository
import com.danteyu.studio.weatherforecast.network.LoadApiStatus
import com.danteyu.studio.weatherforecast.util.Logger
import com.danteyu.studio.weatherforecast.util.Util.getString
import kotlinx.coroutines.launch

/**
 * Created by George Yu on 2020/4/23.
 *
 * The [ViewModel] that is attached to the [HomeFragment].
 */
class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _homeItems = MutableLiveData<List<HomeItem>>()

    val homeItem: LiveData<List<HomeItem>>
        get() = _homeItems

    private val _navigateToDetail = MutableLiveData<Temperature>()

    val navigateToDetail: LiveData<Temperature>
        get() = _navigateToDetail

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

        getWeatherForecastResult(true)
    }

    /**
     * track [WeatherRepository.getWeatherForecast]: -> [DefaultWeatherRepository] : [WeatherRepository] -> [RemoteDataSource] : [WeatherDataSource]
     */
    private fun getWeatherForecastResult(isInitial: Boolean = false) {

        viewModelScope.launch {

            if (isInitial) _status.value = LoadApiStatus.LOADING
            // It will return Result object after Deferred flow
            val result = weatherRepository.getWeatherForecast()

            _homeItems.value = when (result) {
                is Result.Success -> {
                    _error.value = null
                    if (isInitial) _status.value = LoadApiStatus.DONE
                    result.data
                }
                is Result.Fail -> {
                    _error.value = result.error
                    if (isInitial) _status.value = LoadApiStatus.ERROR
                    null
                }
                is Result.Error -> {
                    _error.value = result.exception.toString()
                    if (isInitial) _status.value = LoadApiStatus.ERROR
                    null
                }
                else -> {
                    _error.value = getString(R.string.you_know_nothing)
                    if (isInitial) _status.value = LoadApiStatus.ERROR
                    null
                }
            }
            _refreshStatus.value = false
        }
    }

    fun navigateToDetail(temperature: Temperature) {
        _navigateToDetail.value = temperature
    }

    fun onDetailNavigated() {
        _navigateToDetail.value = null
    }

    fun refresh() {
        if (_status.value != LoadApiStatus.LOADING) {
            getWeatherForecastResult()
        }

    }
}