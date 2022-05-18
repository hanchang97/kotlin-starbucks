package com.hanchang97.starbucks.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import coil.load
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initEventView()
        setEventViewButton()

    }

    private fun initEventView() {
        binding.clEvent.isVisible = true
        binding.ivEvent.load(Common.eventImageUrl)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.eventStateFlow.collect {
                    when (it) {
                        is ApiState.Loading -> {

                            Log.d("AppTest", "load data started")
                        }
                        is ApiState.Error -> {

                            Log.d("AppTest", "load data Error, ${it.message}")
                        }
                        is ApiState.Success -> {
                            binding.event = it.data
                            Log.d("AppTest", "load data success")
                        }
                        is ApiState.Empty -> {

                        }
                    }
                }
            }
        }

        mainViewModel.getEventInfo()
    }

    private fun setEventViewButton(){
        binding.btnEventNever.setOnClickListener {
            // 다시 보지 않기
            initMainView()
        }

        binding.btnEventClose.setOnClickListener {
            // 닫기
            initMainView()
        }
    }

    private fun initMainView(){
        binding.clMain.isVisible = true
        binding.clEvent.isVisible = false

        val navController = supportFragmentManager.findFragmentById(R.id.container)?.findNavController()
        navController?.let{
            binding.bottomnavigation.setupWithNavController(it)
        }

    }
}