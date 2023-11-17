package com.zhigaras.booking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.adapterdelegate.CompositeAdapter
import com.zhigaras.booking.R
import com.zhigaras.booking.databinding.FragmentBookingBinding
import com.zhigaras.booking.ui.adapters.BookingInfoAdapter
import com.zhigaras.booking.ui.adapters.HotelInfoAdapter
import com.zhigaras.core.BaseFragment
import com.zhigaras.uikit.MarginDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingFragment : BaseFragment<FragmentBookingBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentBookingBinding.inflate(inflater)
    
    private val viewModel: BookingViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.navBar.root.setHeader(getString(R.string.booking))
        val adapter = CompositeAdapter.Builder()
            .addAdapter(HotelInfoAdapter())
            .addAdapter(BookingInfoAdapter())
            .build()
        
        binding.bookingRecyclerView.apply {
            this.adapter = adapter
            addItemDecoration(MarginDecoration(resources.getDimensionPixelSize(com.zhigaras.uikit.R.dimen.main_card_dimen)))
        }
        viewModel.scopeCollect {
            it.update(binding)
        }
    }
}