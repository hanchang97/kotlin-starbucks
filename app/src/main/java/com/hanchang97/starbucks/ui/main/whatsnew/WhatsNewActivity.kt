package com.hanchang97.starbucks.ui.main.whatsnew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.databinding.ActivityWhatsnewBinding

class WhatsNewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityWhatsnewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_whatsnew)
        binding.lifecycleOwner = this


    }
}