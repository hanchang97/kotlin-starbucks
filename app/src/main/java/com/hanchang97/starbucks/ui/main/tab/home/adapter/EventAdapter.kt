package com.hanchang97.starbucks.ui.main.tab.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.databinding.ItemHomeEventlistBinding
import com.hanchang97.starbucks.model.home.eventall.EventInfo

class EventAdapter : ListAdapter<EventInfo, EventAdapter.HomeEventViewHolder>(diffUtil) {

    class HomeEventViewHolder(private val binding: ItemHomeEventlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(eventInfo: EventInfo) {
            binding.tvEventTitle.text = eventInfo.title
            binding.ivEventImage.load(Common.eventDetailImageBaseUrl + eventInfo.mobTHUM)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeEventViewHolder {
        val binding =
            ItemHomeEventlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeEventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeEventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<EventInfo>() {
            override fun areItemsTheSame(oldItem: EventInfo, newItem: EventInfo): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: EventInfo, newItem: EventInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}