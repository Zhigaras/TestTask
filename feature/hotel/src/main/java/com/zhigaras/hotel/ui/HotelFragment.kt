package com.zhigaras.hotel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import com.zhigaras.core.BaseFragment
import com.zhigaras.hotel.R
import com.zhigaras.hotel.databinding.FragmentHotelBinding
import com.zhigaras.rooms.ui.RoomsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelFragment : BaseFragment<FragmentHotelBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentHotelBinding.inflate(inflater)
    
    private val viewModel: HotelViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.connectionError.retryButton.setOnClickListener {
            viewModel.fetchHotelInfo()
        }
        binding.bottomButton.button.apply {
            setText(R.string.to_room_choose)
            setOnClickListener {
                viewModel.navigateToRoomChoosing(
                    bundleOf(RoomsFragment.HOTEL_NAME_KEY to binding.aboutHotelLayout.hotelInfo.hotelName.text)
                )
            }
        }
        viewModel.scopeCollect {
            it.update(binding)
        }
    }
}