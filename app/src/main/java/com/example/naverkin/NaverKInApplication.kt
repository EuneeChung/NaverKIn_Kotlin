package com.example.naverkin

import android.app.Application
import com.example.naverkin.di.networkModule
import com.example.naverkin.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NaverKInApplication : Application() {

    private val moduleList= listOf(repositoryModule, networkModule)
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidContext(this@NaverKInApplication)
            modules(moduleList)
        }
    }
}