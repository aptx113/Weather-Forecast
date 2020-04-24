package com.danteyu.studio.weatherforecast.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danteyu.studio.weatherforecast.data.HomeItem
import com.danteyu.studio.weatherforecast.data.Temperature
import com.danteyu.studio.weatherforecast.data.WeatherImage
import com.danteyu.studio.weatherforecast.databinding.ItemHomeImageBinding
import com.danteyu.studio.weatherforecast.databinding.ItemHomeWeatherBinding
import java.lang.ClassCastException

/**
 * Created by George Yu on 2020/4/24.
 *
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * [HomeItem], including computing diffs between lists.
 */
class HomeAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<HomeItem, RecyclerView.ViewHolder>(DiffCallback) {

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [Temperature]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [Temperature]
     */
    class OnClickListener(val clickListener: (temperature: Temperature) -> Unit) {
        fun onClick(temperature: Temperature) = clickListener(temperature)
    }

    class WeatherViewHolder(private var binding: ItemHomeWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(temperature: Temperature, onClickListener: OnClickListener) {
            binding.temperature = temperature
            binding.root.setOnClickListener { onClickListener.onClick(temperature) }
            binding.executePendingBindings()
        }
    }

    class ImageViewHolder(private var binding: ItemHomeImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: WeatherImage) {
            binding.image = image
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<HomeItem>() {
        override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem.id == newItem.id
        }

        private const val ITEM_VIEW_TYPE_TEMPERATURE = 0x00
        private const val ITEM_VIEW_TYPE_IMAGE = 0x01
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_TEMPERATURE -> WeatherViewHolder(
                ItemHomeWeatherBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            ITEM_VIEW_TYPE_IMAGE -> ImageViewHolder(
                ItemHomeImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is WeatherViewHolder -> {
                holder.bind(
                    (getItem(position) as HomeItem.WeatherForecastData).temperature,
                    onClickListener
                )
            }
            is ImageViewHolder -> {
                holder.bind((getItem(position) as HomeItem.Image).image)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeItem.WeatherForecastData -> ITEM_VIEW_TYPE_TEMPERATURE
            is HomeItem.Image -> ITEM_VIEW_TYPE_IMAGE
        }
    }
}
