package com.danteyu.studio.weatherforecast

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danteyu.studio.weatherforecast.data.HomeItem
import com.danteyu.studio.weatherforecast.home.HomeAdapter
import com.danteyu.studio.weatherforecast.network.LoadApiStatus

/**
 * Created by George Yu on 2020/4/23.
 */
@BindingAdapter("homeItems")
fun bindRecyclerViewWithHomeItems(recyclerView: RecyclerView, homeItems: List<HomeItem>?) {
    homeItems?.let {
        recyclerView.adapter?.apply {
            when (this) {
                is HomeAdapter -> submitList(it)
            }
        }
    }
}

@BindingAdapter("value","unit")
fun bindTemperature(textView: TextView, value: String?, unit: String?) {
    value?.let {
        textView.text =
            WeatherApplication.instance.getString(R.string.temperature_with_unit, it, unit)
    }
}

/**
 * According to [LoadApiStatus] to decide the visibility of [ProgressBar]
 */
@BindingAdapter("setupApiStatus")
fun bindApiStatus(view: ProgressBar, status: LoadApiStatus?) {
    when (status) {
        LoadApiStatus.LOADING -> view.visibility = View.VISIBLE
        else -> view.visibility = View.GONE
    }
}

/**
 * According to [message] to decide the visibility of [TextView]
 */
@BindingAdapter("setupApiErrorMessage")
fun bindApiErrorMessage(view: TextView, message: String?) {
    when (message) {
        null, "" -> {
            view.visibility = View.GONE
        }
        else -> {
            view.text = message
            view.visibility = View.VISIBLE
        }
    }
}