package com.hanchang97.starbucks.ui.main.tab.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.hanchang97.starbucks.databinding.ItemHomeMenuBinding
import com.hanchang97.starbucks.model.home.menu.MenuData

class MenuAdapter(private val menuClick: (product_cd: String) -> Unit): ListAdapter<MenuData, MenuAdapter.HomeMenuViewHolder >(diffUtil) {

    class HomeMenuViewHolder(private val binding: ItemHomeMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuData: MenuData, menuClick: (product_cd: String) -> Unit){
            binding.tvMenuName.text = menuData.menuInfo?.product_NM

            val imageUrl = menuData.menuImage?.imgUPLOADPATH + menuData.menuImage?.filePATH
            binding.ivMenuImage.load(imageUrl){
                transformations(CircleCropTransformation())
            }

            if(menuData.rank != 0){
                binding.tvRank.isVisible = true
                binding.tvRank.text = menuData.rank.toString()
            }

            binding.root.setOnClickListener {
                menuData.menuInfo?.product_CD?.let {
                    menuClick.invoke(it)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMenuViewHolder {
        val binding = ItemHomeMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeMenuViewHolder, position: Int) {
        holder.bind(getItem(position), menuClick)
    }


    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<MenuData>() {
            override fun areItemsTheSame(oldItem: MenuData, newItem: MenuData): Boolean {
                return oldItem.menuInfo?.product_CD == newItem.menuInfo?.product_CD
            }

            override fun areContentsTheSame(oldItem: MenuData, newItem: MenuData): Boolean {
                return oldItem == newItem
            }
        }
    }
}