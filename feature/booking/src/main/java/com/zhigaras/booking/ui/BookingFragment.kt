package com.zhigaras.booking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.booking.databinding.FragmentBookingBinding
import com.zhigaras.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingFragment : BaseFragment<FragmentBookingBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentBookingBinding.inflate(inflater)
    
    private val viewModel: BookingViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.scopeCollect {
            it.update(binding)
        }
    }
}