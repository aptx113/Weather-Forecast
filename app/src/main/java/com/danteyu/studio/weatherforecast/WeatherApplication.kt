package com.danteyu.studio.weatherforecast

import android.app.Application
import com.danteyu.studio.weatherforecast.data.source.WeatherRepository
import com.danteyu.studio.weatherforecast.util.ServiceLocator
import kotlin.properties.Delegates

/**
 * Created by George Yu on 2020/4/22.
 *
 * An application that lazily provides a repository. Note that this Service Locator pattern is
 * used to simplify Dependency Injection framework.
 */
class WeatherApplication : Application() {

    val weatherRepository: WeatherRepository
        get() = ServiceLocator.provideRepository(this)

    companion object {
        var instance: WeatherApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}