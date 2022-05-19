package com.hanchang97.starbucks.ui.main.tab.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.databinding.FragmentFavoriteBinding
import com.hanchang97.starbucks.databinding.FragmentHomeBinding
import com.hanchang97.starbucks.ui.main.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Common.printLog("HomeFragment/ onViewCreated")

        getHomeInfo()
    }

    private fun getHomeInfo(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                homeViewModel.homeInfoStateFlow.collect{
                    when(it){
                        is ApiState.Loading -> {
                            Log.d("AppTest", "getHomeInfo/ load data started")
                        }
                        is ApiState.Error -> {
                            Log.d("AppTest", "getHomeInfo/ load data Error, ${it.message}")
                        }
                        is ApiState.Success -> {
                            Log.d("AppTest", "getHomeInfo/ load data success")
                            binding.homeInfo = it.data

                            val mainImageUrl = it.data.mainEvent?.imgUPLOADPATH + it.data.mainEvent?.mobTHUM
                            binding.ivMainEvent.load(mainImageUrl)
                        }
                        is ApiState.Empty -> {

                        }
                    }
                }
            }
        }

        homeViewModel.getHomeInfo()
    }
}