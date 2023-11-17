package com.zhigaras.rooms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.core.BaseFragment
import com.zhigaras.rooms.databinding.FragmentRoomsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomsFragment : BaseFragment<FragmentRoomsBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentRoomsBinding.inflate(inflater)
    
    private val viewModel: RoomsViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.scopeCollect {
            it.update(binding)
        }
    }
}