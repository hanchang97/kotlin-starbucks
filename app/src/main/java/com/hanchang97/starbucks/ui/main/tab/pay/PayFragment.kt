package com.hanchang97.starbucks.ui.main.tab.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.databinding.FragmentFavoriteBinding
import com.hanchang97.starbucks.databinding.FragmentPayBinding

class PayFragment: Fragment() {

    private lateinit var binding: FragmentPayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pay, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Common.printLog("PayFragment/ onViewCreated")

    }
}