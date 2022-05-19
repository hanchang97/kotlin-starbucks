package com.hanchang97.starbucks.ui.main.tab.order.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.hanchang97.starbucks.databinding.ItemOrderListBinding
import com.hanchang97.starbucks.model.order.OrderInfo

class OrderAdapter(private val orderClick: (title: String, menuListUrl: String) -> Unit) : ListAdapter<OrderInfo, OrderAdapter.OrderViewHolder>(diffUtil) {

    class OrderViewHolder(private val binding: ItemOrderListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(orderInfo: OrderInfo, orderClick: (title: String, menuListUrl: String) -> Unit) {
            binding.orderInfo = orderInfo
            binding.ivOrderImage.load(orderInfo.imageUrl) {
                transformations(CircleCropTransformation())
            }
            binding.root.setOnClickListener {
                orderClick.invoke(orderInfo.title!!, orderInfo.menuListUrl!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding =
            ItemOrderListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(getItem(position), orderClick)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<OrderInfo>() {
            override fun areItemsTheSame(oldItem: OrderInfo, newItem: OrderInfo): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: OrderInfo, newItem: OrderInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}