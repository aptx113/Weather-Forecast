package com.danteyu.studio.weatherforecast.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.danteyu.studio.weatherforecast.databinding.FragmentHomeBinding
import com.danteyu.studio.weatherforecast.ext.getVmFactory

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    /**
     * Lazily initialize [HomeViewModel]
     */
    private val viewModel by viewModels<HomeViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recyclerHome.adapter = HomeAdapter(HomeAdapter.OnClickListener {

        })

        binding.layoutSwipeRefreshHome.setOnRefreshListener {
            viewModel.refresh()
        }

        viewModel.refreshStatus.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.layoutSwipeRefreshHome.isRefreshing = it
            }
        })


        return binding.root
    }

}
