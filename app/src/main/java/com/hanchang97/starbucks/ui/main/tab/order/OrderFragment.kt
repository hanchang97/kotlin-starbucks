package com.hanchang97.starbucks.ui.main.tab.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.databinding.FragmentOrderBinding
import com.hanchang97.starbucks.ui.main.tab.order.adapter.OrderAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var orderAdapter: OrderAdapter
    private val orderViewModel: OrderViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false)
        val view = binding.root
        return view

        // return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Common.printLog("OrderFragment/ onViewCreated")

        setOrderRV()
    }

    private fun setOrderRV(){
        orderAdapter = OrderAdapter(){
            title, menuListUrl ->
        }
        binding.rvOrder.apply {
            adapter = orderAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        orderAdapter.submitList(orderViewModel.foodList.toList())
    }
}