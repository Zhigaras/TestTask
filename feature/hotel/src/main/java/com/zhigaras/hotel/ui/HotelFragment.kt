package com.zhigaras.hotel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.core.BaseFragment
import com.zhigaras.hotel.databinding.FragmentHotelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelFragment : BaseFragment<FragmentHotelBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentHotelBinding.inflate(inflater)
    
    private val viewModel: HotelViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.connectionError.retryButton.setOnClickListener {
            viewModel.fetchHotelInfo()
        }
        
        binding.toRoomChooseButton.setOnClickListener {
            viewModel.navigateToRoomChoosing()
        }
        
        viewModel.scopeCollect {
            it.update(binding)
        }
    }
}