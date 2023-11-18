package com.zhigaras.ordered.ui

import android.view.LayoutInflater
import com.zhigaras.core.BaseFragment
import com.zhigaras.ordered.databinding.FragmentOrderedBinding

class OrderedFragment : BaseFragment<FragmentOrderedBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentOrderedBinding.inflate(inflater)
}