package com.zhigaras.core

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import kotlin.properties.Delegates

class NavigationImpl : Navigation {
    
    private lateinit var fragmentManager: FragmentManager
    private var container by Delegates.notNull<Int>()
    
    override fun setUpNavigation(fragmentManager: FragmentManager, container: Int) {
        this.fragmentManager = fragmentManager
        this.container = container
    }
    
    override fun goAndAddToBackStack(fragment: Class<out BaseFragment<*>>, args: Bundle?) {
        fragmentManager.beginTransaction()
            .replace(container, fragment, args)
            .addToBackStack(fragment.simpleName)
            .commit()
    }
}