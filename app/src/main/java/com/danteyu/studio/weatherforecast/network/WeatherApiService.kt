package com.danteyu.studio.weatherforecast.network

import com.danteyu.studio.weatherforecast.BuildConfig
import com.danteyu.studio.weatherforecast.data.WeatherForecastResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Created by George Yu on 2020/4/23.
 */

private const val HOST_NAME = "opendata.cwb.gov.tw"
private const val API_VERSION = "v1"
private const val BASE_URL = "https://$HOST_NAME/api/$API_VERSION/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = when (BuildConfig.LOGGER_VISIABLE) {
            true -> HttpLoggingInterceptor.Level.BODY
            false -> HttpLoggingInterceptor.Level.NONE
        }
    })
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .client(client)
    .build()

/**
 * A public interface that exposes the [getWeatherForecastAsync] methods
 */
interface WeatherApiService {

    @GET("rest/datastore/F-C0032-001?Authorization=CWB-B3C14D37-3272-4A86-9BA6-78FCC21CF666&locationName=%E8%87%BA%E5%8C%97%E5%B8%82&elementName=MinT&sort=time")
    fun getWeatherForecastAsync():
    // The Coroutine Call Adapter allows us to return a Deferred, a Job with a result
            Deferred<WeatherForecastResponse>

}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object WeatherApi {
    val retrofitService: WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}