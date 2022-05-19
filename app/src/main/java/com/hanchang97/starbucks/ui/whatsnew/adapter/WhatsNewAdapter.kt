package com.hanchang97.starbucks.ui.whatsnew.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hanchang97.starbucks.databinding.ItemWhatsnewListBinding
import com.hanchang97.starbucks.model.whatsnew.WhatsNewInfo

class WhatsNewAdapter: ListAdapter<WhatsNewInfo, WhatsNewAdapter.WhatsNewViewHolder>(diffUtil) {

    class WhatsNewViewHolder(private val binding: ItemWhatsnewListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(whatsNewInfo: WhatsNewInfo) {
           binding.whatsnewInfo = whatsNewInfo
           binding.ivEventImage.load("https://image.istarbucks.co.kr/upload/promotion/APP_THUM_20220429124801969.jpg")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WhatsNewViewHolder {
        val binding =
            ItemWhatsnewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WhatsNewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WhatsNewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<WhatsNewInfo>() {
            override fun areItemsTheSame(oldItem: WhatsNewInfo, newItem: WhatsNewInfo): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: WhatsNewInfo, newItem: WhatsNewInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}