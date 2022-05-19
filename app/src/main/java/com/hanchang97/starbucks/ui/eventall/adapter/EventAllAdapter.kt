package com.hanchang97.starbucks.ui.eventall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.databinding.ItemEventAllListBinding
import com.hanchang97.starbucks.model.home.eventall.EventInfo

class EventAllAdapter : ListAdapter<EventInfo, EventAllAdapter.EventAllViewHolder>(diffUtil) {

    class EventAllViewHolder(private val binding: ItemEventAllListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(eventInfo: EventInfo) {
            binding.eventInfo = eventInfo
            binding.ivEventImage.load(Common.eventDetailImageBaseUrl + eventInfo.mobTHUM)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAllViewHolder {
        val binding =
            ItemEventAllListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventAllViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventAllViewHolder, position: Int) {
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