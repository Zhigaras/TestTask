package com.zhigaras.testtask

import android.app.Application
import com.zhigaras.hotel.di.hotelModule
import org.koin.core.context.startKoin

class App : Application() {
    
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(mainModule())
                        + hotelModule()
            )
        }
    }
}