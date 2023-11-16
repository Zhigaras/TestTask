package com.zhigaras.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhigaras.hotel.ui.HotelFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HotelFragment())
                .addToBackStack(HotelFragment::class.java.simpleName)
                .commit()
    }
}