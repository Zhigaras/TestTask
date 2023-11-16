package com.zhigaras.hotel.ui

import android.view.LayoutInflater
import com.zhigaras.core.BaseFragment
import com.zhigaras.hotel.databinding.FragmentHotelBinding

class HotelFragment : BaseFragment<FragmentHotelBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentHotelBinding.inflate(inflater)
    
    
}