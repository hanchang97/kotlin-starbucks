package com.hanchang97.starbucks.ui.eventall

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
import com.hanchang97.starbucks.databinding.ActivityEventallBinding
import com.hanchang97.starbucks.ui.eventall.adapter.EventAllAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventAllActivity : AppCompatActivity() {

    private val eventAllViewModel: EventAllViewModel by viewModel()
    private lateinit var binding: ActivityEventallBinding
    private lateinit var eventAllAdapter: EventAllAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_eventall)
        binding.lifecycleOwner = this

        setSupportActionBar(binding.materialToolbar)  // 액션바로 xml에 만들어준 toolbar를 사용한다
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼 활성화
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)

        setEventAllRV()
        getEventAllList()
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

    private fun setEventAllRV() {
        eventAllAdapter = EventAllAdapter()
        binding.rvEvent.apply {
            adapter = eventAllAdapter
            layoutManager = LinearLayoutManager(this@EventAllActivity)
        }
    }

    private fun getEventAllList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                eventAllViewModel.eventAllInfoListStateFlow.collect {
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
                            eventAllAdapter.submitList(it.data.toList())
                            Log.d("AppTest", "getWhatsNewList/ load data success")
                        }
                        is ApiState.Empty -> {

                        }
                    }
                }
            }
        }

        eventAllViewModel.getEventAllList()
    }

}