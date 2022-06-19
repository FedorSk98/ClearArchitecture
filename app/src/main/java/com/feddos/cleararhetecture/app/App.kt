package com.feddos.cleararhetecture.app

import android.app.Application
import com.feddos.cleararhetecture.di.AppComponent
import com.feddos.cleararhetecture.di.AppModule
import com.feddos.cleararhetecture.di.DaggerAppComponent


class App: Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(context = this))
            .build()

    }
}