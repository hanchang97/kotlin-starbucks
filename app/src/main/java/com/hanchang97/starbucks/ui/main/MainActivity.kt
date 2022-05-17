package com.hanchang97.starbucks.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import coil.load
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initEventView()
    }

    private fun initEventView(){
        binding.clEvent.isVisible = true
        binding.ivEvent.load(Common.eventImageUrl)
    }
}