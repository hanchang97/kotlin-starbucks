package com.hanchang97.starbucks.ui.main.whatsnew

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.databinding.ActivityWhatsnewBinding
import com.hanchang97.starbucks.ui.main.whatsnew.adapter.WhatsNewAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class WhatsNewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWhatsnewBinding
    private val whatsNewViewModel: WhatsNewViewModel by viewModel()

    private lateinit var whatsNewAdapter: WhatsNewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_whatsnew)
        binding.lifecycleOwner = this

        setSupportActionBar(binding.materialToolbar)  // 액션바로 xml에 만들어준 toolbar를 사용한다
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼 활성화
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)
        //supportActionBar!!.setDisplayShowTitleEnabled(false) // 기본제목 없애기

        setWhatsNewRV()
        getWhatsNewList()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // 좌측 상단 뒤로가기 누를 시
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setWhatsNewRV(){
        whatsNewAdapter = WhatsNewAdapter()
        binding.rvEvent.apply {
            adapter = whatsNewAdapter
            layoutManager = LinearLayoutManager(this@WhatsNewActivity)
        }
    }

    private fun getWhatsNewList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                whatsNewViewModel.whatsNewInfoListStateFlow.collect {
                    when (it) {
                        is ApiState.Loading -> {
                            binding.progressBar.isVisible = true
                            Log.d("AppTest", "getWhatsNewList/ load data started")
                        }
                        is ApiState.Error -> {
                            binding.progressBar.isVisible = false
                            Log.d("AppTest", "getWhatsNewList/ load data Error, ${it.message}")
                        }
                        is ApiState.Success -> {
                            binding.progressBar.isVisible = false
                            whatsNewAdapter.submitList(it.data.toList())
                            Log.d("AppTest", "getWhatsNewList/ load data success")
                        }
                        is ApiState.Empty -> {

                        }
                    }
                }
            }
        }

        whatsNewViewModel.getWhatsNewList()
    }
}