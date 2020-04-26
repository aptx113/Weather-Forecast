package com.danteyu.studio.weatherforecast.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.danteyu.studio.weatherforecast.R
import com.danteyu.studio.weatherforecast.databinding.FragmentDetailBinding
import com.danteyu.studio.weatherforecast.ext.getVmFactory

class DetailFragment : Fragment() {

    /**
     * Lazily initialize [DetailViewModel]
     */
    private val viewModel by viewModels<DetailViewModel> {
        getVmFactory(
            DetailFragmentArgs.fromBundle(
                requireArguments()
            ).temperatureKey
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.viewModel = viewModel


        return binding.root
    }

}
