package com.hanchang97.starbucks.ui.menudetail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.databinding.ActivityMenuDetailBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuDetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMenuDetailBinding
    private val menuDetailViewModel: MenuDetailViewModel by viewModel()
    private var product_cd = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu_detail)
        binding.lifecycleOwner = this

        intent.getStringExtra("product_cd")?.let {
            product_cd = it

            Log.d("AppTest", "MenuDetailActivity/ product_cd : ${it}")

            getMenuImage()
            getMenuInfo()
        }

    }

    private fun getMenuImage(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                menuDetailViewModel.menuImageStateFlow.collect{
                    when (it) {
                        is ApiState.Loading -> {
                            binding.progressBar.isVisible = true
                            Log.d("AppTest", "getMenuImage/ load data started")
                        }
                        is ApiState.Error -> {
                            binding.progressBar.isVisible = false
                            Log.d("AppTest", "getMenuImage/ load data Error, ${it.message}")
                        }
                        is ApiState.Success -> {
                            binding.progressBar.isVisible = false
                            binding.ivMenuImage.load(it.data.imgUPLOADPATH + it.data.filePATH)
                            Log.d("AppTest", "getMenuImage/ load data success")
                        }
                        is ApiState.Empty -> {

                        }
                    }
                }
            }
        }

        menuDetailViewModel.getMenuImage(product_cd)
    }

    private fun getMenuInfo(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                menuDetailViewModel.menuInfoStateFlow.collect{
                    when (it) {
                        is ApiState.Loading -> {
                            binding.progressBar.isVisible = true
                            Log.d("AppTest", "getMenuInfo/ load data started")
                        }
                        is ApiState.Error -> {
                            binding.progressBar.isVisible = false
                            Log.d("AppTest", "getMenuInfo/ load data Error, ${it.message}")
                        }
                        is ApiState.Success -> {
                            binding.progressBar.isVisible = false
                            binding.menuInfo = it.data
                            Log.d("AppTest", "getMenuInfo/ load data success")
                        }
                        is ApiState.Empty -> {

                        }
                    }
                }
            }
        }

        menuDetailViewModel.getMenuInfo(product_cd)
    }
}