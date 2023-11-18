package com.zhigaras.ordered.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.core.BaseFragment
import com.zhigaras.ordered.R
import com.zhigaras.ordered.databinding.FragmentOrderedBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderedFragment : BaseFragment<FragmentOrderedBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentOrderedBinding.inflate(inflater)
    private val viewModel: OrderedViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.navBar.root.addBackNavigation(parentFragmentManager)
        binding.navBar.navBarTitle.setText(R.string.order_has_been_paid)
        binding.bottomButton.button.setOnClickListener {
        
        }
    }
}