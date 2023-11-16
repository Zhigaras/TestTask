package com.zhigaras.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

abstract class BaseFragment<B : ViewBinding> : Fragment() {
    
    private var _binding: B? = null
    protected val binding get() = _binding!!
    
    protected abstract fun initBinding(inflater: LayoutInflater): B
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = initBinding(inflater)
        return binding.root
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    protected fun <T : UiState<*>> BaseViewModel<T>.scopeCollect(collector: FlowCollector<T>) {
        viewLifecycleOwner.lifecycleScope.launch {
            this@scopeCollect.collect(collector)
        }
    }
}