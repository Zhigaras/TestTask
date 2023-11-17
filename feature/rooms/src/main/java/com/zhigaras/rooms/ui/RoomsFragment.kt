package com.zhigaras.rooms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.core.BaseFragment
import com.zhigaras.rooms.databinding.FragmentRoomsBinding

class RoomsFragment : BaseFragment<FragmentRoomsBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentRoomsBinding.inflate(inflater)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }
}