package com.zhigaras.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhigaras.core.Navigation
import com.zhigaras.hotel.ui.HotelFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val navigation: Navigation by inject()
        navigation.setUpNavigation(supportFragmentManager, R.id.container)
        
        if (savedInstanceState == null)
            navigation.goTo(HotelFragment::class.java)
    }
}