package com.hanchang97.starbucks.ui.main.tab.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.hanchang97.starbucks.database.MenuEntity
import com.hanchang97.starbucks.databinding.ItemFavoriteListBinding

class FavoriteAdapter(private val moveToOrder: (product_cd: String) -> Unit): ListAdapter<MenuEntity, FavoriteAdapter.FavoriteViewHolder >(diffUtil) {

    class FavoriteViewHolder(private val binding: ItemFavoriteListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuEntity: MenuEntity, moveToOrder: (product_cd: String) -> Unit) {
            binding.menuEntity = menuEntity
            binding.ivOrderImage.load(menuEntity.menu_image_url){
                transformations(CircleCropTransformation())
            }

            binding.btnOrder.setOnClickListener {
                moveToOrder.invoke(menuEntity.product_cd)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding =
            ItemFavoriteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position), moveToOrder)
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MenuEntity>() {
            override fun areItemsTheSame(oldItem: MenuEntity, newItem: MenuEntity): Boolean {
                return oldItem.product_cd == newItem.product_cd
            }

            override fun areContentsTheSame(oldItem: MenuEntity, newItem: MenuEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}