package com.hanchang97.starbucks.ui.main.tab.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanchang97.starbucks.R
import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.databinding.FragmentFavoriteBinding
import com.hanchang97.starbucks.ui.main.tab.favorite.adapter.FavoriteAdapter
import com.hanchang97.starbucks.ui.menudetail.MenuDetailActivity
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment: Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Common.printLog("FavoriteFragment/ onViewCreated")

        setFavoriteListRV()
    }

    private fun setFavoriteListRV(){
        favoriteAdapter = FavoriteAdapter {
            val intent = Intent(requireContext(), MenuDetailActivity::class.java)
            intent.putExtra("product_cd", it)
            startActivity(intent)
        }

        binding.rvFavorite.apply {
            adapter = favoriteAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                favoriteViewModel.getAllFavoriteMenu().collect{
                    favoriteAdapter.submitList(it.toList())
                }
            }
        }
    }
}