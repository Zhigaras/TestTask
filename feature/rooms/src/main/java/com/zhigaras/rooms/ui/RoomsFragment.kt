package com.zhigaras.rooms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.adapterdelegate.CompositeAdapter
import com.zhigaras.core.BaseFragment
import com.zhigaras.rooms.databinding.FragmentRoomsBinding
import com.zhigaras.uikit.MarginDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.zhigaras.uikit.R

class RoomsFragment : BaseFragment<FragmentRoomsBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentRoomsBinding.inflate(inflater)
    
    private val viewModel: RoomsViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val adapter = CompositeAdapter.Builder()
            .addAdapter(RoomsAdapter { viewModel.navigateToBooking() })
            .build()
        
        binding.roomsRecyclerView.apply {
            this.adapter = adapter
            addItemDecoration(MarginDecoration(resources.getDimensionPixelSize(R.dimen.main_card_dimen)))
        }
        arguments?.getString(HOTEL_NAME_KEY)?.let { binding.navBar.root.setHeader(it) }
        binding.navBar.root.addBackNavigation(parentFragmentManager)
        
        binding.connectionError.retryButton.setOnClickListener {
            viewModel.fetchRooms()
        }
        
        viewModel.scopeCollect {
            it.update(binding)
        }
    }
    
    companion object {
        const val HOTEL_NAME_KEY = "hotelNameKey"
    }
}